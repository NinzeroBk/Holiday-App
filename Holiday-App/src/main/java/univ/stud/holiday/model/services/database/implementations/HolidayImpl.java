package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.common.Pair;
import univ.stud.holiday.model.daos.HolidayDao;
import univ.stud.holiday.model.entities.Holiday;

import java.sql.*;
import java.util.ArrayList;
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchElement(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {
        String sql = "DELETE FROM holidays WHERE holidayId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Holiday holiday) {
        String sql = "UPDATE holidays " +
                "SET username = ?," +
                "title = ?," +
                "description = ?," +
                "startDate = ?," +
                "endDate = ?" +
                "WHERE holidayId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, holiday.getUsername());
            preparedStatement.setString(2, holiday.getTitle());
            preparedStatement.setString(3, holiday.getDescription());
            preparedStatement.setDate(4, Date.valueOf(holiday.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(holiday.getEndDate()));
            preparedStatement.setInt(6, holiday.getHolidayId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Holiday holiday) {
        String sql = "INSERT INTO holidays(title, " +
                "username, " +
                "description, " +
                "startDate, " +
                "endDate) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
        List<Holiday> holidays = new ArrayList<>();
        String sql = "SELECT * FROM holidays;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                holidays.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return holidays;
    }

    @Override
    public Pair<Holiday, Double> mostExpensiveHoliday(@NotNull String username) {
        String sql = "SELECT holidays.*, COALESCE(SUM(baseCost), 0) + COALESCE(SUM(price), 0) TotalPrice\n" +
                "FROM users\n" +
                "JOIN holidays USING(username)\n" +
                "JOIN visited USING(holidayId)\n" +
                "JOIN attractions USING(attractionId)\n" +
                "LEFT JOIN expenses USING(visitedId)\n" +
                "WHERE username LIKE ?\n" +
                "GROUP BY holidayId\n" +
                "ORDER BY COALESCE(SUM(baseCost), 0) + COALESCE(SUM(price), 0) DESC\n" +
                "LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Pair<>(fetchElement(resultSet), resultSet.getDouble("TotalPrice"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Holiday longestHoliday(@NotNull String username) {
        String sql = "SELECT holidays.* " +
                "FROM users " +
                "JOIN holidays USING(username) " +
                "WHERE username LIKE ? " +
                "GROUP BY holidayId " +
                "ORDER BY endDate - startDate DESC " +
                "LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return fetchElement(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
