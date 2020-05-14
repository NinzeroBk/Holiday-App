package univ.stud.holiday.servlets.resources;

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

@WebServlet("/holiday-app/resources/resource-edit")
public class ResourceEditServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebMapper.of(MySqlDatabaseHoliday.getInstance().resourceDao().readElement((Integer) req.getSession().getAttribute("resourceId")))
                .forEach(req::setAttribute);
        req.getRequestDispatcher("/holiday-app/resources/ResourceEdit.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("visitedId", req.getSession().getAttribute("visitedId"));
        objectMap.put("resourceId", req.getSession().getAttribute("resourceId"));
        try {
            if (MySqlDatabaseHoliday.getInstance().resourceDao().updateElement(WebMapper.toResource(objectMap))) {
                resp.sendRedirect("/holiday-app/visits/visit-view");
            } else {
                throw new RuntimeException("Could not update the resource!");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "/holiday-app/resources/ResourceEdit.jsp");
        }
    }
}
