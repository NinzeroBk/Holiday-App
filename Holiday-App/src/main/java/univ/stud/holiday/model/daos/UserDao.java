package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.entities.User;

public interface UserDao extends BaseDao<User, String> {
    boolean isValidUser(@NotNull String username);

    double totalCost(@NotNull String username);
}

