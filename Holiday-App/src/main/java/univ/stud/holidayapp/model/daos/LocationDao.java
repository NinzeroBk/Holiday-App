package univ.stud.holidayapp.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.entities.Location;

public interface LocationDao extends BaseDao<Location, Integer> {
    Location mostVisitedAttraction(@NotNull String username);
}
