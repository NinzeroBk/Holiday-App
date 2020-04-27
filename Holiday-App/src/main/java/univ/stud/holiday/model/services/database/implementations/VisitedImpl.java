package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.common.Pair;
import univ.stud.holiday.model.daos.VisitedDao;
import univ.stud.holiday.model.entities.Visited;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VisitedImpl extends DatabaseImpl<Visited> implements VisitedDao {

    public VisitedImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Visited fetchElement(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Visited readElement(@NotNull Pair<Integer, Integer> primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Pair<Integer, Integer> primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Visited visited) {

    }

    @Override
    public void createElement(@NotNull Visited visited) {
        System.out.println(visited);
    }

    @Override
    public List<Visited> getElements() {
        return null;
    }
}
