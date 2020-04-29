package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.CountryDao;
import univ.stud.holiday.model.entities.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryImpl extends DatabaseImpl<Country> implements CountryDao {


    public CountryImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Country fetchElement(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getInt("countryId"),
                resultSet.getInt("regionId"),
                resultSet.getString("name")
        );
    }

    @Override
    public Country readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM countries WHERE countryId = ?";
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
        String sql = "DELETE FROM countries WHERE countryId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateElement(@NotNull Country country) {
        String sql = "UPDATE countries " +
                "SET regionId = ?," +
                "name = ?" +
                "WHERE countryId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, country.getRegionId());
            preparedStatement.setString(2, country.getName());
            preparedStatement.setInt(3, country.getCountryId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createElement(@NotNull Country country) {
        String sql = "INSERT INTO countries(regionId, name) VALUES(?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, country.getRegionId());
            preparedStatement.setString(2, country.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Country> getElements() {
        List<Country> countryList = new ArrayList<>();
        String sql = "SELECT * FROM countries";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                countryList.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countryList;
    }
}
