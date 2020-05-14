package univ.stud.holiday.servlets.visits;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.common.WebPage;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/visits/visit-create")
public class VisitCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("VisitCreate.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("holidayId", req.getSession().getAttribute("holidayId"));
        try {
            if (MySqlDatabaseHoliday.getInstance().visitedDao().createElement(WebMapper.toVisited(objectMap))) {
                resp.sendRedirect("/holiday-app/visits");
            } else {
                throw new RuntimeException("Could not create a visit!");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "VisitCreate.jsp");
        }
    }
}
