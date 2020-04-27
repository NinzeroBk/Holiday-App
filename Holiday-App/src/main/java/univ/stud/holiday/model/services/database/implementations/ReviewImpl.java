package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ReviewDao;
import univ.stud.holiday.model.entities.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReviewImpl extends DatabaseImpl<Review> implements ReviewDao {


    public ReviewImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Review fetchElement(ResultSet resultSet) throws SQLException {
        return null;
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
