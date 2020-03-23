package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.AttractionDao;
import univ.stud.holiday.model.entities.Attraction;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class AttractionImpl extends DatabaseImpl implements AttractionDao {

    public AttractionImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
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
