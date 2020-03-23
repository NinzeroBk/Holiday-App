package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.CountryDao;
import univ.stud.holiday.model.entities.Country;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class CountryImpl extends DatabaseImpl implements CountryDao {

    public CountryImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
    }

    @Override
    public Country readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Country country) {

    }

    @Override
    public void createElement(@NotNull Country country) {

    }

    @Override
    public List<Country> getElements() {
        return null;
    }
}
