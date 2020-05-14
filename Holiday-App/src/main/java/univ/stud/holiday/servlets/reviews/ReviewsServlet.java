package univ.stud.holiday.servlets.reviews;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/reviews")
public class ReviewsServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);

        Integer reviewId = null;
        String operation = (String) objectMap.get("operation");

        if (operation == null) {
            throw new RuntimeException("No operation was selected!");
        } else if (!operation.equals("Create")) {
            reviewId = Integer.parseInt((String) objectMap.get("id"));
        }

        switch (operation) {
            case "Create":
                resp.sendRedirect("reviews/review-create");
                break;
            case "Edit":
                req.getSession().setAttribute("reviewId", reviewId);
                resp.sendRedirect("reviews/review-edit");
                break;
            case "Delete":
                if (MySqlDatabaseHoliday.getInstance().reviewDao().deleteElement(reviewId)) {
                    resp.sendRedirect("visits/visit-view");
                } else {
                    throw new RuntimeException("Could not delete the review!");
                }
                break;
            default:
                throw new RuntimeException("Invalid operation!");
        }
    }
}
