package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.entities.Holiday;

public interface HolidayDao extends BaseDao<Holiday, Integer> {
    @SQL(query = "SELECT holidays.*, SUM(baseCost) + SUM(price) \n" +
                "FROM users\n" +
                "JOIN holidays USING(username)\n" +
                "JOIN visited USING(holidayId)\n" +
                "JOIN attractions USING(attractionId)\n" +
                "LEFT JOIN expenses USING(visitedId)\n" +
                "WHERE username LIKE ?\n" +
                "GROUP BY holidayId\n" +
                "ORDER BY SUM(baseCost) + SUM(price) DESC\n" +
                "LIMIT 1;")
    Holiday mostExpensiveHoliday(@NotNull String username);

    @SQL(query = "SELECT holidays.*\n" +
                "FROM users\n" +
                "JOIN holidays USING(username)\n" +
                "WHERE username LIKE ?\n" +
                "GROUP BY holidayId\n" +
                "ORDER BY endDate - startDate DESC\n" +
                "LIMIT 1;")
    Holiday longestHoliday(@NotNull String username);
}
