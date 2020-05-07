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
import java.util.stream.Stream;

@WebServlet("/holiday-app/user-create")
public class UserCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("UserCreate.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> userMap = WebMapper.of(req);
        try {
            HolidayRepository.createUser(WebMapper.toUser(userMap));
            req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
        } catch (Exception exception) {
            userMap.forEach(req::setAttribute);
            req.setAttribute("errorMessage", switch (exception.getSuppressed().length) {
                case 0 -> "Empty field(s) detected.";
                default -> Stream.of(exception.getSuppressed()).map(Throwable::getMessage)
                        .collect(Collectors.joining(" "));
            });
            req.getRequestDispatcher("UserCreate.jsp").forward(req, resp);
        }
    }
}
