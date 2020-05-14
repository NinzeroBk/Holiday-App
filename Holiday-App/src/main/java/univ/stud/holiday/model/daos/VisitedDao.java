package univ.stud.holiday.model.daos;

import univ.stud.holiday.model.entities.Visited;

import java.util.List;

public interface VisitedDao extends BaseDao<Visited, Integer> {
    List<Visited> fetchVisitsForHoliday(int holidayId);
}
