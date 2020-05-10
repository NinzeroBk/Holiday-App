package univ.stud.holiday.servlets.users;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.HolidayRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/user-create")
public class UserCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user-create/UserCreate.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> userMap = WebMapper.of(req);
        try {
            if (HolidayRepository.userExists((String) userMap.get("username"))) {
                throw new RuntimeException("User already exists!");
            }
            HolidayRepository.createUser(WebMapper.toUser(userMap));
            resp.sendRedirect("user-login");
        } catch (Exception exception) {
            userMap.forEach(req::setAttribute);
            req.setAttribute("errorMessage", exception.getMessage());
            req.getRequestDispatcher("user-create/UserCreate.jsp").forward(req, resp);
        }
    }
}
