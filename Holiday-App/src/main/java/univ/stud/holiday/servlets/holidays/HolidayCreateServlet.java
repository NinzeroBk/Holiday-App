package univ.stud.holiday.servlets.holidays;

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

@WebServlet("/holiday-app/holidays/holiday-create")
public class HolidayCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("HolidayCreate.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        try {
            if (MySqlDatabaseHoliday.getInstance().holidayDao().createElement(WebMapper.toHoliday(objectMap))) {
                resp.sendRedirect("/holiday-app/holidays");
            } else {
                throw new RuntimeException("Could not create holiday.");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "/holiday-app/holidays/HolidayCreate.jsp");
        }
    }
}
