package univ.stud.holiday.servlets.attractions;

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

@WebServlet("/holiday-app/attractions/attraction-create")
public class AttractionCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AttractionCreate.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("attractionId", req.getSession().getAttribute("attractionId"));
        try {
            if(MySqlDatabaseHoliday.getInstance().attractionDao().createElement(WebMapper.toAttraction(objectMap))) {
                resp.sendRedirect("/holiday-app/attractions");
            } else {
                throw new RuntimeException("Could not create an attraction!");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "AttractionCreate.jsp");
        }
    }
}
