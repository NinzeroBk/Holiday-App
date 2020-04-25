package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.entities.User;

import java.lang.annotation.*;

public interface UserDao extends BaseDao<User, String> {
    boolean isValidUser(@NotNull String username);
    @SQL(query = "SELECT SUM(baseCost) + SUM(price)\n" +
            "FROM users\n" +
            "JOIN holidays USING(username)\n" +
            "JOIN visited USING(holidayId)\n" +
            "JOIN attractions USING(attractionId)\n" +
            "LEFT JOIN expenses USING(visitedId)" +
            "WHERE username = ?;")
    double totalCost(@NotNull String username);
}

