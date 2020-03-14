package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.daos.RegionDao;
import univ.stud.holidayapp.model.entities.Region;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class RegionImpl extends DatabaseImpl implements RegionDao {

    public RegionImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
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
