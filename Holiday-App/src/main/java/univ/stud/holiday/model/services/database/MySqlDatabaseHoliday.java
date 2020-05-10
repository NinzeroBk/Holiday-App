package univ.stud.holiday.model.services.database;

import univ.stud.holiday.model.HolidayRepository;
import univ.stud.holiday.model.daos.*;
import univ.stud.holiday.model.services.database.implementations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabaseHoliday implements HolidayRepository.HolidayAdapter, AutoCloseable {

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

    private static final String USERNAME = "root";

    private static final String PASSWORD = "adminpass1";

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DATABASE_CONNECTION = "jdbc:mysql://localhost:3306/holiday";

    private final Connection connection;

    private MySqlDatabaseHoliday() {
        super();
        try {
            Class.forName(DATABASE_DRIVER);
            System.out.println(" Connecting to database... ");
            connection = DriverManager.getConnection(DATABASE_CONNECTION, USERNAME, PASSWORD);
            System.out.println(" Connection is successful ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not establish a connection to the database.");
        }
    }


    @Override
    public void close() throws Exception {
    }

    private static class SingletonHelper {
        private static final MySqlDatabaseHoliday INSTANCE = new MySqlDatabaseHoliday();
    }

    public static MySqlDatabaseHoliday getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public AttractionDao attractionDao() {
        if (attractionDao == null) {
            synchronized (this) {
                if (attractionDao == null) {
                    attractionDao = new AttractionImpl(connection);
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
                    resourceDao = new ResourceImpl(connection);
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
                    locationDao = new LocationImpl(connection);
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
                    countryDao = new CountryImpl(connection);
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
                    expenseDao = new ExpenseImpl(connection);
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
                    holidayDao = new HolidayImpl(connection);
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
                    visitedDao = new VisitedImpl(connection);
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
                    regionDao = new RegionImpl(connection);
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
                    reviewDao = new ReviewImpl(connection);
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
                    userDao = new UserImpl(connection);
                }
            }
        }
        return userDao;
    }
}