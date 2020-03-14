package univ.stud.holidayapp.model.daos;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.entities.Holiday;

public interface HolidayDao extends BaseDao<Holiday, Integer> {
    Holiday mostExpensiveHoliday(@NotNull String username);

    Holiday longestHoliday(@NotNull String username);
}
