package univ.stud.holiday.model;

import univ.stud.holiday.model.daos.*;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

public class HolidayRepository {
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

    private HolidayAdapter dataSource;
    private static HolidayRepository INSTANCE = null;

    private HolidayRepository() {
        dataSource = new MySqlDatabaseHoliday();
    }

    public static HolidayRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (HolidayRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HolidayRepository();
                }
            }
        }
        return INSTANCE;
    }

    public HolidayAdapter getDataSource() {
        return dataSource;
    }
}
