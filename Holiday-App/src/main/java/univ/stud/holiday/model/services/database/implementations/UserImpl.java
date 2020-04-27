package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.UserDao;
import univ.stud.holiday.model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImpl extends DatabaseImpl<User> implements UserDao {

    public UserImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    User fetchElement(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("imageUrl"),
                resultSet.getString("emailAddress"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName")
        );
    }


    @Override
    public User readElement(@NotNull String primaryKey) {
        try {
            String sql = "SELECT * FROM users WHERE username like '" + primaryKey + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return fetchElement(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteElement(@NotNull String primaryKey) {
        String sql = "DELETE FROM users WHERE username like ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull User user) {
        String sql= "UPDATE users " +
                    "SET password = ?," +
                    "imageUrl = ?," +
                    "emailAddress = ?," +
                    "firstName = ?," +
                    "lastName = ?" +
                    "WHERE username like ?";
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, user.getPassword());
             preparedStatement.setString(2, user.getImageUrl());
             preparedStatement.setString(3, user.getEmailAddress());
             preparedStatement.setString(4, user.getFirstName());
             preparedStatement.setString(5, user.getLastName());
             preparedStatement.setString(6, user.getUsername());
             preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull User user) {
        String sql = "INSERT INTO users(username, password, imageUrl, emailAddress, firstName, lastName) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getImageUrl());
            preparedStatement.setString(4, user.getEmailAddress());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getElements() {
        String sql = "SELECT * FROM users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> userList = new ArrayList<>();

            while (resultSet.next()) {
                User user = fetchElement(resultSet);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isValidUser(@NotNull String username) {
        String sql = "SELECT count(username) " +
                     "from users " +
                     "where username like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return resultSet.getInt("count(username)")==1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double totalCost(@NotNull String username) {
        String sql = "SELECT SUM(baseCost) + SUM(price) Total\n" +
                "FROM users\n" +
                "JOIN holidays USING(username)\n" +
                "JOIN visited USING(holidayId)\n" +
                "JOIN attractions USING(attractionId)\n" +
                "LEFT JOIN expenses USING(visitedId)" +
                "WHERE username = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                return resultSet.getDouble("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
