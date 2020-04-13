package univ.stud.holiday.model.services.database;

import univ.stud.holiday.model.HolidayRepository;
import univ.stud.holiday.model.daos.*;
import univ.stud.holiday.model.services.database.implementations.*;

public class MySqlDatabaseHoliday implements HolidayRepository.HolidayAdapter {

    /**
     * DAOs
     */
    private AttractionDao attractionDao;
    private LocationDao locationDao;
    private ResourceDao resourceDao;
    private VisitedDao visitedDao;
    private CountryDao countryDao;
    private ExpenseDao expenseDao;
    private HolidayDao holidayDao;
    private RegionDao regionDao;
    private ReviewDao reviewDao;
    private UserDao userDao;

    private static final String USERNAME = "fusedbloxxer";

    private static final String PASSWORD = "default_password";

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DATABASE_CONNECTION = "jdbc:mysql://localhost:3306/holiday_database";

    public MySqlDatabaseHoliday() {
        super();
    }

    @Override
    public AttractionDao attractionDao() {
        if (attractionDao == null) {
            synchronized (this) {
                if (attractionDao == null) {
                    attractionDao = new AttractionImpl(this);
                }
            }
        }
        return attractionDao;
    }

    @Override
    public ResourceDao resourceDao() {
        if (resourceDao == null) {
            synchronized (this) {
                if (resourceDao == null) {
                    resourceDao = new ResourceImpl(this);
                }
            }
        }
        return resourceDao;
    }

    @Override
    public LocationDao locationDao() {
        if (locationDao == null) {
            synchronized (this) {
                if (locationDao == null) {
                    locationDao = new LocationImpl(this);
                }
            }
        }
        return locationDao;
    }

    @Override
    public CountryDao countryDao() {
        if (countryDao == null) {
            synchronized (this) {
                if (countryDao == null) {
                    countryDao = new CountryImpl(this);
                }
            }
        }
        return countryDao;
    }

    @Override
    public ExpenseDao expenseDao() {
        if (expenseDao == null) {
            synchronized (this) {
                if (expenseDao == null) {
                    expenseDao = new ExpenseImpl(this);
                }
            }
        }
        return expenseDao;
    }

    @Override
    public HolidayDao holidayDao() {
        if (holidayDao == null) {
            synchronized (this) {
                if (holidayDao == null) {
                    holidayDao = new HolidayImpl(this);
                }
            }
        }
        return holidayDao;
    }

    @Override
    public VisitedDao visitedDao() {
        if (visitedDao == null) {
            synchronized (this) {
                if (visitedDao == null) {
                    visitedDao = new VisitedImpl(this);
                }
            }
        }
        return visitedDao;
    }

    @Override
    public RegionDao regionDao() {
        if (regionDao == null) {
            synchronized (this) {
                if (regionDao == null) {
                    regionDao = new RegionImpl(this);
                }
            }
        }
        return regionDao;
    }

    @Override
    public ReviewDao reviewDao() {
        if (reviewDao == null) {
            synchronized (this) {
                if (reviewDao == null) {
                    reviewDao = new ReviewImpl(this);
                }
            }
        }
        return reviewDao;
    }

    @Override
    public UserDao userDao() {
        if (userDao == null) {
            synchronized (this) {
                if (userDao == null) {
                    userDao = new UserImpl(this);
                }
            }
        }
        return userDao;
    }
}