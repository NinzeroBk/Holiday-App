package univ.stud.holiday.model.daos;

import univ.stud.holiday.model.entities.Expense;

import java.util.List;

public interface ExpenseDao extends BaseDao<Expense, Integer> {
    List<Expense> fetchExpensesForVisit(int visitedId);
}
