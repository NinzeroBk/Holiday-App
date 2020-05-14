package univ.stud.holiday.servlets.expenses;

import univ.stud.holiday.common.WebMapper;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/holiday-app/expenses")
public class ExpensesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("expenses/Expense.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> objectMap = WebMapper.of(req);

        String operation = (String) objectMap.get("operation");

        if (operation == null) {
            throw new RuntimeException("No operation was selected.");
        } else if (!operation.equals("Create") && objectMap.get("id") == null) {
            throw new RuntimeException("No expense was selected!");
        }

        if (operation.equals("Create")) {
            resp.sendRedirect("expenses/expense-create");
        } else {
            final int expenseId = Integer.parseInt((String) objectMap.get("id"));
            if (operation.equals("Edit")) {
                req.getSession().setAttribute("expenseId", expenseId);
                resp.sendRedirect("expenses/expense-edit");
            } else if (operation.equals("Delete")) {
                if (MySqlDatabaseHoliday.getInstance().expenseDao().deleteElement(expenseId)) {
                    resp.sendRedirect("visits/visit-view");
                } else {
                    throw new RuntimeException("Could not delete the expense!");
                }
            } else {
                throw new RuntimeException("Invalid operation!");
            }
        }
    }
}
