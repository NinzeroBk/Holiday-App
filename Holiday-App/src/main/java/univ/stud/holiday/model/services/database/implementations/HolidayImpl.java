package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.HolidayDao;
import univ.stud.holiday.model.entities.Holiday;

import java.sql.*;
import java.util.List;

public class HolidayImpl extends DatabaseImpl<Holiday> implements HolidayDao {


    public HolidayImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Holiday fetchElement(ResultSet resultSet) throws SQLException {
        return new Holiday(
                resultSet.getInt("holidayId"),
                resultSet.getString("title"),
                resultSet.getString("username"),
                resultSet.getString("description"),
                resultSet.getDate("startDate").toLocalDate(),
                resultSet.getDate("endDate").toLocalDate()
        );
    }

    @Override
    public Holiday readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM holidays WHERE holidayId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return fetchElement(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String sql = "INSERT INTO holidays( title, " +
                                            "username, " +
                                            "description, " +
                                            "startDate, " +
                                            "endDate) " +
                        "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, holiday.getHolidayId());
            preparedStatement.setString(1, holiday.getTitle());
            preparedStatement.setString(2, holiday.getUsername());
            preparedStatement.setString(3, holiday.getDescription());
            preparedStatement.setDate(4, Date.valueOf(holiday.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(holiday.getEndDate()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
