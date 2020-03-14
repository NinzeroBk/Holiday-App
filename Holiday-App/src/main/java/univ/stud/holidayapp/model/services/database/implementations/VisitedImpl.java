package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.common.Pair;
import univ.stud.holidayapp.model.daos.VisitedDao;
import univ.stud.holidayapp.model.entities.Visited;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class VisitedImpl extends DatabaseImpl implements VisitedDao {

    public VisitedImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
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
