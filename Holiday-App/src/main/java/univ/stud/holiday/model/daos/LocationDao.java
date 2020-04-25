package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.entities.Location;

import java.util.stream.Stream;

public interface LocationDao extends BaseDao<Location, Integer> {
    @SQL(query = "SELECT locations.*\n" +
                "FROM locations JOIN attractions USING(locationId)\n" +
                "JOIN visited USING(attractionId)\n" +
                "JOIN holidays USING(holidayId)\n" +
                "JOIN users USING(username)\n" +
                "WHERE username LIKE ?\n" +
                "GROUP BY locationId\n" +
                "ORDER BY count(visitedId) DESC\n" +
                "LIMIT 1;")
    Location mostVisitedAttraction(@NotNull String username);



}
