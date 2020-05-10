package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.RegionDao;
import univ.stud.holiday.model.entities.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionImpl extends DatabaseImpl<Region> implements RegionDao {


    public RegionImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Region fetchElement(ResultSet resultSet) throws SQLException {
        return new Region(
                resultSet.getInt("regionId"),
                resultSet.getString("name")
        );
    }

    @Override
    public Region readElement(@NotNull Integer primaryKey) {
        String sql = "SELECT * FROM regions WHERE regionID = ?";
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
        String sql = "DELETE FROM regions WHERE regionId = ?";
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
    public boolean updateElement(@NotNull Region region) {
        String sql = "UPDATE regions " +
                "SET name = ? " +
                "WHERE regionId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createElement(@NotNull Region region) {
        String sql = "INSERT INTO regions(name) VALUES(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, region.getName());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Region> getElements() {
        String sql = "SELECT * FROM regions";
        List<Region> regions = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                regions.add(fetchElement(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }
}
