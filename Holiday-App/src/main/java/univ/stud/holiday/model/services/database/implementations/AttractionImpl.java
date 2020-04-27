package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.AttractionDao;
import univ.stud.holiday.model.entities.Attraction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AttractionImpl extends DatabaseImpl<Attraction> implements AttractionDao {


    public AttractionImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Attraction fetchElement(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Attraction readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {
    }

    @Override
    public void updateElement(@NotNull Attraction attraction) {

    }

    @Override
    public void createElement(@NotNull Attraction attraction) {

    }

    @Override
    public List<Attraction> getElements() {
        return null;
    }
}
