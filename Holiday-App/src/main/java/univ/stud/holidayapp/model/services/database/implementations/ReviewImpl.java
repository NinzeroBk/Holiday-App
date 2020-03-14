package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.daos.ReviewDao;
import univ.stud.holidayapp.model.entities.Review;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class ReviewImpl extends DatabaseImpl implements ReviewDao {

    public ReviewImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
    }

    @Override
    public Review readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Review review) {

    }

    @Override
    public void createElement(@NotNull Review review) {

    }

    @Override
    public List<Review> getElements() {
        return null;
    }
}
