package univ.stud.holiday.servlets.expenses;

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

@WebServlet("/holiday-app/expenses/expense-edit")
public class ExpenseEditServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebMapper.of(MySqlDatabaseHoliday.getInstance().expenseDao().readElement((Integer) req.getSession().getAttribute("expenseId")))
                .forEach(req::setAttribute);
        req.getRequestDispatcher("ExpenseEdit.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);
        objectMap.put("visitedId", req.getSession().getAttribute("visitedId"));
        objectMap.put("expenseId", req.getSession().getAttribute("expenseId"));
        try {
            if (MySqlDatabaseHoliday.getInstance().expenseDao().updateElement(WebMapper.toExpense(objectMap))) {
                resp.sendRedirect("/holiday-app/visits/visit-view");
            } else {
                throw new RuntimeException("Could not update the expense!");
            }
        } catch (Exception exception) {
            WebPage.retry(req, resp, objectMap, exception, "/holiday-app/expenses/ExpenseEdit.jsp");
        }
    }
}
