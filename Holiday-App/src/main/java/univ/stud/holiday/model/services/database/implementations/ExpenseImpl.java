package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ExpenseDao;
import univ.stud.holiday.model.entities.Expense;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class ExpenseImpl extends DatabaseImpl implements ExpenseDao {

    public ExpenseImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
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
