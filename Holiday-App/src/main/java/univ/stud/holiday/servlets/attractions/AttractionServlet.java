package univ.stud.holiday.servlets.attractions;


import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/attractions")
public class AttractionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("attractions/Attractions.jsp").forward(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, Object> map = WebMapper.of(req);

        String attractionOperation = (String) map.get("operation");

        if (attractionOperation == null) {
            throw new RuntimeException("No operation was selected!");
        } else if (!attractionOperation.equals("Create") && map.get("id") == null) {
            throw new RuntimeException("No attraction was selected!");
        } else if (attractionOperation.equals("Create")) {
            resp.sendRedirect("attractions/attraction-create");
            return;
        }

            int attractionId = Integer.parseInt((String) map.get("id"));

        switch (attractionOperation) {
            case "Edit" -> {
                req.getSession().setAttribute("attractionId", attractionId);
                resp.sendRedirect("attractions/attraction-edit");
            }
            case "Delete" -> {
                MySqlDatabaseHoliday.getInstance().attractionDao().deleteElement(attractionId);
                req.getRequestDispatcher("attractions/Attractions.jsp").forward(req, resp);
            }
            default -> throw new RuntimeException("Invalid operation.");
        }
    }
}