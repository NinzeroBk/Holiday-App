package univ.stud.holiday.servlets.resources;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/resources")
public class ResourcesServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);

        String operation = (String) objectMap.get("operation");

        if (operation == null) {
            throw new RuntimeException("No operation was selected!");
        } else if (!operation.equals("Create") && objectMap.get("id") == null) {
            throw new RuntimeException("No resource was selected!");
        }

        if (operation.equals("Create")) {
            resp.sendRedirect("/holiday-app/resources/resource-create");
        } else {
            int resourceId = Integer.parseInt((String) objectMap.get("id"));
            if (operation.equals("Edit")) {
                req.getSession().setAttribute("resourceId", resourceId);
                resp.sendRedirect("/holiday-app/resources/resource-edit");
            } else if (operation.equals("Delete")) {
                if (MySqlDatabaseHoliday.getInstance().resourceDao().deleteElement(resourceId)) {
                    resp.sendRedirect("/holiday-app/visits/visit-view");
                } else {
                    throw new RuntimeException("Could not delete the resource.");
                }
            }
        }
    }
}
