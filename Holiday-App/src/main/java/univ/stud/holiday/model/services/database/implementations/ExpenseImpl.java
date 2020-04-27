package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ExpenseDao;
import univ.stud.holiday.model.entities.Expense;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpenseImpl extends DatabaseImpl<Expense> implements ExpenseDao {


    public ExpenseImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Expense fetchElement(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Expense readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Expense expense) {

    }

    @Override
    public void createElement(@NotNull Expense expense) {

    }

    @Override
    public List<Expense> getElements() {
        return null;
    }
}
