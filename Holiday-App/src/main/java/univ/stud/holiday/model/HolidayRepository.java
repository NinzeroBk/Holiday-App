package univ.stud.holiday.model;

import univ.stud.holiday.model.daos.*;
import univ.stud.holiday.model.entities.Holiday;
import univ.stud.holiday.model.entities.User;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public final class HolidayRepository {

    public interface HolidayAdapter {
        AttractionDao attractionDao();

        ResourceDao resourceDao();

        LocationDao locationDao();

        CountryDao countryDao();

        ExpenseDao expenseDao();

        HolidayDao holidayDao();

        VisitedDao visitedDao();

        RegionDao regionDao();

        ReviewDao reviewDao();

        UserDao userDao();
    }

    private HolidayRepository() {
        throw new AssertionError();
    }

    public static boolean userExists(String username) {
        return MySqlDatabaseHoliday.getInstance().userDao().userExists(username);
    }

    public static boolean isLoginValid(String username, String password) {
        return MySqlDatabaseHoliday.getInstance().userDao().isLoginValid(username, password);
    }

    public static User fetchUser(String username) {
        return MySqlDatabaseHoliday.getInstance().userDao().readElement(username);
    }

    public static List<Holiday> fetchHolidaysForUser(String username) {
        return MySqlDatabaseHoliday.getInstance().holidayDao().fetchHolidaysForUser(username);
    }
}
