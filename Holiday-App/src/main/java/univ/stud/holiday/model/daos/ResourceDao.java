package univ.stud.holiday.model.daos;

import univ.stud.holiday.model.entities.Resource;

import java.util.List;

public interface ResourceDao extends BaseDao<Resource, Integer> {
    List<Resource> fetchResourcesForVisit(int visitedId);
}
