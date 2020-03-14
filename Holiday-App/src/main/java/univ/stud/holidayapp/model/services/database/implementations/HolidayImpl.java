package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.daos.HolidayDao;
import univ.stud.holidayapp.model.entities.Holiday;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class HolidayImpl extends DatabaseImpl implements HolidayDao {

    public HolidayImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
    }

    @Override
    public Holiday readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Holiday holiday) {

    }

    @Override
    public void createElement(@NotNull Holiday holiday) {

    }

    @Override
    public List<Holiday> getElements() {
        return null;
    }

    @Override
    public Holiday mostExpensiveHoliday(@NotNull String username) {
        return null;
    }

    @Override
    public Holiday longestHoliday(@NotNull String username) {
        return null;
    }
}
