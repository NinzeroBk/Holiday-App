package univ.stud.holiday.servlets.holidays;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/holidays")
public class HolidayServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("holidays/Holidays.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> map = WebMapper.of(req);

        String holidayOperation = (String) map.get("operation");

        if (holidayOperation == null) {
            throw new RuntimeException("No operation was selected!");
        } else if (holidayOperation.equals("Logout")) {
            req.getSession().removeAttribute("username");
            resp.sendRedirect("/holiday-app");
            return;
        } else if (holidayOperation.equals("Delete Account")) {
            if (MySqlDatabaseHoliday.getInstance().userDao().deleteElement((String) req.getSession().getAttribute("username"))) {
                req.getSession().removeAttribute("username");
                resp.sendRedirect("/holiday-app");
                return;
            } else {
                throw new RuntimeException("Could not delete the user!");
            }
        } else if (!holidayOperation.equals("Create") && map.get("id") == null) {
            throw new RuntimeException("No holiday was selected!");
        } else if (holidayOperation.equals("Create")) {
            resp.sendRedirect("holidays/holiday-create");
            return;
        }

        int holidayId = Integer.parseInt((String) map.get("id"));

        switch (holidayOperation) {
            case "Edit" -> {
                req.getSession().setAttribute("holidayId", holidayId);
                resp.sendRedirect("holidays/holiday-edit");
            }
            case "Delete" -> {
                MySqlDatabaseHoliday.getInstance().holidayDao().deleteElement(holidayId);
                req.getRequestDispatcher("holidays/Holidays.jsp").forward(req, resp);
            }
            case "View" -> {
                req.getSession().setAttribute("holidayId", holidayId);
                resp.sendRedirect("visits");
            }
            default -> throw new RuntimeException("Invalid operation.");
        }
    }
}
