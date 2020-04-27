package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.ResourceDao;
import univ.stud.holiday.model.entities.Resource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResourceImpl extends DatabaseImpl<Resource> implements ResourceDao {


    public ResourceImpl(@NotNull Connection connection) {
        super(connection);
    }

    @Override
    Resource fetchElement(ResultSet resultSet) throws SQLException {
        return null;
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
