package univ.stud.holiday.servlets.visits;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/visits")
public class VisitsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("visits/Visits.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        String operation = (String) objectMap.get("operation");

        if (operation == null) {
            throw new RuntimeException("No operation was selected!");
        } else if (operation.equals("Create")) {
            resp.sendRedirect("visits/visit-create");
        } else if (objectMap.get("id") == null) {
            throw new RuntimeException("No visit was selected!");
        } else {
            int visitedId = Integer.parseInt((String) objectMap.get("id"));
            switch (operation) {
                case "View":
                    req.getSession().setAttribute("visitedId", visitedId);
                    resp.sendRedirect("visits/visit-view");
                    break;
                case "Edit":
                    req.getSession().setAttribute("visitedId", visitedId);
                    resp.sendRedirect("visits/visit-edit");
                    break;
                case "Delete":
                    if (MySqlDatabaseHoliday.getInstance().visitedDao().deleteElement(visitedId)) {
                        req.getRequestDispatcher("visits/Visits.jsp").forward(req, resp);
                    } else {
                        throw new RuntimeException("Could not delete element.");
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid operation.");
            }
        }
    }
}
