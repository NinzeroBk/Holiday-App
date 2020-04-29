package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ResourceDao;
import univ.stud.holiday.model.entities.Resource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceImpl extends DatabaseImpl<Resource> implements ResourceDao {


    public ResourceImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Resource fetchElement(ResultSet resultSet) throws SQLException {
        return new Resource(
                resultSet.getInt("resourceId"),
                resultSet.getInt("visitedId"),
                resultSet.getString("title"),
                resultSet.getString("imageUrl"),
                resultSet.getTimestamp("timestamp").toLocalDateTime()
        );
    }

    @Override
    public Resource readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM resources WHERE resourceId = ?";
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
        String sql = "DELETE FROM resources WHERE resourceId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Resource resource) {
        String sql = "UPDATE resources " +
                "SET visitedId = ?," +
                "title = ?," +
                "imageUrl = ?," +
                "timestamp = ? " +
                "WHERE resourceId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, resource.getVisitedId());
            preparedStatement.setString(2, resource.getTitle());
            preparedStatement.setString(3, resource.getImageUrl());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(resource.getTimestamp()));
            preparedStatement.setInt(5, resource.getResourceId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Resource resource) {
        String sql = "INSERT INTO resources(visitedId, title, imageUrl, timestamp) VALUES(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, resource.getVisitedId());
            preparedStatement.setString(2, resource.getTitle());
            preparedStatement.setString(3, resource.getImageUrl());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(resource.getTimestamp()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Resource> getElements() {
        String sql = "SELECT * FROM resources";
        List<Resource> resources = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                resources.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resources;
    }
}
