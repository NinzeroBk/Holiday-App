package univ.stud.holiday.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class WebPage {
    private WebPage() {
        throw new AssertionError();
    }

    public static void retry(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> objectMap, Exception exception, String path) throws ServletException, IOException {
        objectMap.forEach(req::setAttribute);
        req.setAttribute("errorMessage", exception.getMessage() + " " +
                Stream.of(exception.getSuppressed())
                        .map(Throwable::getMessage)
                        .collect(Collectors.joining(". ")));
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
