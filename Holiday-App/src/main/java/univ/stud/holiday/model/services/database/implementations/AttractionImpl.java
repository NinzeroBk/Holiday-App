package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.AttractionDao;
import univ.stud.holiday.model.entities.Attraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionImpl extends DatabaseImpl<Attraction> implements AttractionDao {


    public AttractionImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Attraction fetchElement(ResultSet resultSet) throws SQLException {
        return new Attraction(
                resultSet.getInt("attractionId"),
                resultSet.getString("description"),
                resultSet.getDouble("baseCost"),
                resultSet.getInt("locationId"),
                resultSet.getString("name"),
                resultSet.getInt("year")
        );
    }

    @Override
    public Attraction readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM attractions WHERE attractionId = ?";
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
        String sql = "DELETE FROM attractions WHERE attractionId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Attraction attraction) {
        String sql = "UPDATE attractions " +
                "SET locationId = ?," +
                "baseCost = ?," +
                "name = ?," +
                "description = ?," +
                "year = ? " +
                "WHERE attractionId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, attraction.getLocationId());
            preparedStatement.setDouble(2, attraction.getBaseCost());
            preparedStatement.setString(3, attraction.getName());
            preparedStatement.setString(4, attraction.getDescription());
            preparedStatement.setInt(5, attraction.getYear());
            preparedStatement.setInt(6, attraction.getAttractionId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Attraction attraction) {
        String sql = "INSERT INTO attractions(locationId, baseCost, name, description, year) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, attraction.getLocationId());
            preparedStatement.setDouble(2, attraction.getBaseCost());
            preparedStatement.setString(3, attraction.getName());
            preparedStatement.setString(4, attraction.getDescription());
            preparedStatement.setInt(5, attraction.getYear());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Attraction> getElements() {
        String sql = "SELECT * FROM attractions";
        List<Attraction> attractionList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                attractionList.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attractionList;
    }
}
