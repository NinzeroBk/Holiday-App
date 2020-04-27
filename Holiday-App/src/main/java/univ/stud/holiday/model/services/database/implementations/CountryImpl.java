package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.CountryDao;
import univ.stud.holiday.model.entities.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CountryImpl extends DatabaseImpl<Country> implements CountryDao {


    public CountryImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Country fetchElement(ResultSet resultSet) throws SQLException {
        return null;
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
