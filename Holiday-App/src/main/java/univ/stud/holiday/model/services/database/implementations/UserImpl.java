package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.daos.UserDao;
import univ.stud.holiday.model.entities.User;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.util.List;

public class UserImpl extends DatabaseImpl implements UserDao {

    public UserImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        super(mySqlDatabase);
    }

    @Override
    public User readElement(@NotNull String primaryKey) {
        return null;
    }

    @Override
    public void deleteElement(@NotNull String primaryKey) {

    }

    @Override
    public void updateElement(@NotNull User user) {

    }

    @Override
    public void createElement(@NotNull User user) {

    }

    @Override
    public List<User> getElements() {
        return null;
    }

    @Override
    public boolean isValidUser(@NotNull String username) {
        return false;
    }
}
