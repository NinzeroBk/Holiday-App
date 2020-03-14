package univ.stud.holidayapp.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.entities.User;

public interface UserDao extends BaseDao<User, String> {
    boolean isValidUser(@NotNull String username);
}
