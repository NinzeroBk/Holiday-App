package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.entities.Location;

public interface LocationDao extends BaseDao<Location, Integer> {
    Location mostVisitedAttraction(@NotNull String username);
}
