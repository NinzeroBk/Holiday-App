package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ReviewDao;
import univ.stud.holiday.model.entities.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewImpl extends DatabaseImpl<Review> implements ReviewDao {


    public ReviewImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Review fetchElement(ResultSet resultSet) throws SQLException {
        return new Review(
                resultSet.getInt("reviewId"),
                resultSet.getInt("visitedId"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getDouble("rating"),
                resultSet.getTimestamp("timestamp").toLocalDateTime()
        );
    }

    @Override
    public Review readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM reviews WHERE reviewId = ?";
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
    public boolean deleteElement(@NotNull Integer primaryKey) {
        String sql = "DELETE FROM reviews WHERE reviewId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateElement(@NotNull Review review) {
        String sql = "UPDATE reviews " +
                "SET visitedId = ?," +
                "title = ?," +
                "content = ?," +
                "rating = ?," +
                "timestamp = ? " +
                "WHERE reviewId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, review.getVisitedId());
            preparedStatement.setString(2, review.getTitle());
            preparedStatement.setString(3, review.getContent());
            preparedStatement.setDouble(4, review.getRating());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(review.getTimestamp()));
            preparedStatement.setInt(6, review.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createElement(@NotNull Review review) {
        String sql = "INSERT INTO reviews(visitedId, title, content, rating, timestamp) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, review.getVisitedId());
            preparedStatement.setString(2, review.getTitle());
            preparedStatement.setString(3, review.getContent());
            preparedStatement.setDouble(4, review.getRating());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(review.getTimestamp()));
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Review> getElements() {
        String sql = "SELECT * FROM reviews";
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                reviews.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<Review> fetchReviewsForVisit(int visitedId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE visitedId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, visitedId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    reviews.add(fetchElement(resultSet));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reviews;
    }
}
