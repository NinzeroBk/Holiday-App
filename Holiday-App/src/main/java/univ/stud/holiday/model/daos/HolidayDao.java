package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.common.Pair;
import univ.stud.holiday.model.entities.Holiday;

public interface HolidayDao extends BaseDao<Holiday, Integer> {
    Pair<Holiday, Double> mostExpensiveHoliday(@NotNull String username);

    Holiday longestHoliday(@NotNull String username);
}
