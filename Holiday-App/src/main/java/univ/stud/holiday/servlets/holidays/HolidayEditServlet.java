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

@WebServlet("/holiday-app/holidays/holiday-edit")
public class HolidayEditServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebMapper.of(MySqlDatabaseHoliday.getInstance().holidayDao().readElement((Integer) req.getSession().getAttribute("holidayId")))
                .forEach(req::setAttribute);
        req.getRequestDispatcher("HolidayEdit.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("holidayId", req.getSession().getAttribute("holidayId"));
        try {
            if (MySqlDatabaseHoliday.getInstance().holidayDao().updateElement(WebMapper.toHoliday(objectMap))) {
                resp.sendRedirect("/holiday-app/holidays");
            } else {
                throw new RuntimeException("Could not edit holiday.");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "/holiday-app/holidays/HolidayEdit.jsp");
        }
    }
}
