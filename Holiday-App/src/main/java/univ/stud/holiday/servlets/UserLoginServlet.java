package univ.stud.holiday.servlets;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.HolidayRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/holiday-app/user-login")
public class UserLoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> userLoginMap = WebMapper.of(req.getReader().lines().collect(Collectors.joining()));

        boolean isLoginValid = HolidayRepository
                .isLoginValid(userLoginMap.get("username"), userLoginMap.get("password"));

        if (isLoginValid) {
            req.setAttribute("username", userLoginMap.get("username"));
            req.getRequestDispatcher("Holidays.jsp").forward(req, resp);
        } else {
            req.setAttribute("isLoginValid", false);
            req.setAttribute("username", userLoginMap.get("username"));
            req.setAttribute("password", userLoginMap.get("password"));
            req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
        }
    }
}
