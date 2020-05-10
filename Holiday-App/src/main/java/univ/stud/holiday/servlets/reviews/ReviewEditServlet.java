package univ.stud.holiday.servlets.reviews;

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

@WebServlet("/holiday-app/reviews/review-edit")
public class ReviewEditServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebMapper.of(MySqlDatabaseHoliday.getInstance().reviewDao().readElement((Integer) req.getSession().getAttribute("reviewId")))
                .forEach(req::setAttribute);
        req.getRequestDispatcher("ReviewEdit.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("reviewId", req.getSession().getAttribute("reviewId"));
        objectMap.put("visitedId", req.getSession().getAttribute("visitedId"));
        try {
            if (MySqlDatabaseHoliday.getInstance().reviewDao().updateElement(WebMapper.toReview(objectMap))) {
                resp.sendRedirect("/holiday-app/visits/visit-view");
            } else {
                throw new RuntimeException("Could not update the review.");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "/holiday-app/reviews/ReviewEdit.jsp");
        }
    }
}
