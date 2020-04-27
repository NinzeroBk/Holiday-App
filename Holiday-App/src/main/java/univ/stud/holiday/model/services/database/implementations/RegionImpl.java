package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.RegionDao;
import univ.stud.holiday.model.entities.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegionImpl extends DatabaseImpl<Region> implements RegionDao {


    public RegionImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Region fetchElement(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Region readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Region region) {

    }

    @Override
    public void createElement(@NotNull Region region) {

    }

    @Override
    public List<Region> getElements() {
        return null;
    }
}
