package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.daos.CountryDao;
import univ.stud.holidayapp.model.entities.Country;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

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
