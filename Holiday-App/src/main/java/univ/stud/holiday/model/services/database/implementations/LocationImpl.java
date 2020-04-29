package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.LocationDao;
import univ.stud.holiday.model.entities.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationImpl extends DatabaseImpl<Location> implements LocationDao {


    public LocationImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Location fetchElement(ResultSet resultSet) throws SQLException {
        return new Location(
                resultSet.getInt("locationId"),
                resultSet.getInt("countryId"),
                resultSet.getString("streetAddress"),
                resultSet.getString("city"),
                resultSet.getString("stateProvince")
        );
    }

    @Override
    public Location readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM locations WHERE locationId = ?";
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
    public void deleteElement(@NotNull Integer primaryKey) {
        String sql = "DELETE FROM locations WHERE locationId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Location location) {
        String sql = "UPDATE locations " +
                "SET countryId = ?," +
                "streetAddress = ?," +
                "city = ?," +
                "stateProvince = ?" +
                "WHERE locationId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, location.getCountryId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setInt(5, location.getLocationId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Location location) {
        String sql = "INSERT INTO locations(countryId, streetAddress, city, stateProvince) VALUES(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, location.getCountryId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Location> getElements() {
        String sql = "SELECT * FROM locations";
        List<Location> locationList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                locationList.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locationList;
    }

    @Override
    public Location mostVisitedAttraction(@NotNull String username) {
        String sql = "SELECT locations.* " +
                "FROM locations JOIN attractions USING(locationId) " +
                "JOIN visited USING(attractionId) " +
                "JOIN holidays USING(holidayId) " +
                "JOIN users USING(username) " +
                "WHERE username LIKE ? " +
                "GROUP BY locationId " +
                "ORDER BY count(visitedId) DESC " +
                "LIMIT 1;";
        // TODO: TEST
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
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
}
