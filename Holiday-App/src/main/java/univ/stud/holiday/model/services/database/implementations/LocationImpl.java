package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.LocationDao;
import univ.stud.holiday.model.entities.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LocationImpl extends DatabaseImpl<Location> implements LocationDao {


    public LocationImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Location fetchElement(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Location readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Location location) {

    }

    @Override
    public void createElement(@NotNull Location location) {

    }

    @Override
    public List<Location> getElements() {
        return null;
    }

    @Override
    public Location mostVisitedAttraction(@NotNull String username) {
        return null;
    }
}
