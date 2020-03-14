package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.daos.ResourceDao;
import univ.stud.holidayapp.model.entities.Resource;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class ResourceImpl extends DatabaseImpl implements ResourceDao {
    public ResourceImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
    }

    @Override
    public Resource readElement(@NotNull Integer primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull Integer primaryKey) {

    }

    @Override
    public void updateElement(@NotNull Resource resource) {

    }

    @Override
    public void createElement(@NotNull Resource resource) {

    }

    @Override
    public List<Resource> getElements() {
        return null;
    }
}
