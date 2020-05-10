package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ExpenseDao;
import univ.stud.holiday.model.entities.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseImpl extends DatabaseImpl<Expense> implements ExpenseDao {

    public ExpenseImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Expense fetchElement(ResultSet resultSet) throws SQLException {
        return new Expense(
                resultSet.getInt("expenseId"),
                resultSet.getInt("visitedId"),
                resultSet.getDouble("price"),
                resultSet.getString("name")
        );
    }

    @Override
    public Expense readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM expenses WHERE expenseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchElement(resultSet);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteElement(@NotNull Integer primaryKey) {
        String sql = "DELETE FROM expenses WHERE expenseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateElement(@NotNull Expense expense) {
        String sql = "UPDATE expenses " +
                "SET visitedId = ?," +
                "price = ?," +
                "name = ? " +
                "WHERE expenseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, expense.getVisitedId());
            preparedStatement.setDouble(2, expense.getPrice());
            preparedStatement.setString(3, expense.getName());
            preparedStatement.setInt(4, expense.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createElement(@NotNull Expense expense) {
        String sql = "INSERT INTO expenses(visitedId, price, name) VALUES(?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, expense.getVisitedId());
            preparedStatement.setDouble(2, expense.getPrice());
            preparedStatement.setString(3, expense.getName());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Expense> getElements() {
        String sql = "SELECT * FROM expenses";
        List<Expense> expenses = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                expenses.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expenses;
    }

    @Override
    public List<Expense> fetchExpensesForVisit(int visitedId) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE visitedId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, visitedId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    expenses.add(fetchElement(resultSet));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expenses;
    }
}
