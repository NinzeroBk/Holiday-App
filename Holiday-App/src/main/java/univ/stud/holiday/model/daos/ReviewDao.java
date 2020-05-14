package univ.stud.holiday.model.daos;

import univ.stud.holiday.model.entities.Review;

import java.util.List;

public interface ReviewDao extends BaseDao<Review, Integer> {
    List<Review> fetchReviewsForVisit(int visitedId);
}