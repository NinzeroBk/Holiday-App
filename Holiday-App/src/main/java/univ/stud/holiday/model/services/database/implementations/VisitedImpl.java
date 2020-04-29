package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.VisitedDao;
import univ.stud.holiday.model.entities.Visited;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitedImpl extends DatabaseImpl<Visited> implements VisitedDao {

    public VisitedImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Visited fetchElement(ResultSet resultSet) throws SQLException {
        return new Visited(
                resultSet.getInt("visitedId"),
                resultSet.getInt("holidayId"),
                resultSet.getInt("attractionId"),
                resultSet.getTimestamp("startDate").toLocalDateTime(),
                resultSet.getTimestamp("endDate").toLocalDateTime()
        );
    }

    @Override
    public Visited readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM visited WHERE visitedId = ?";
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
        String sql = "DELETE FROM visited " +
                "WHERE visitedId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Visited visited) {
        String sql = "UPDATE visited " +
                "SET holidayId = ?," +
                "attractionId = ?," +
                "startDate = ?," +
                "endDate = ? " +
                "WHERE visitedId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, visited.getHolidayId());
            preparedStatement.setInt(2, visited.getAttractionId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(visited.getStartDate()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(visited.getEndDate()));
            preparedStatement.setInt(5, visited.getVisitedId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Visited visited) {
        String sql = "INSERT INTO visited(holidayId, attractionId, startDate, endDate) VALUES(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, visited.getHolidayId());
            preparedStatement.setInt(2, visited.getAttractionId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(visited.getStartDate()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(visited.getEndDate()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Visited> getElements() {
        String sql = "SELECT * FROM visited";
        List<Visited> visits = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                visits.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return visits;
    }
}
