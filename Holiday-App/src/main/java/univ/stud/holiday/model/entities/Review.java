package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class Review {
    public static final int TITLE_MAX_LENGTH = 25;
    public static final int CONTENT_MAX_LENGTH = 250;

    private int reviewId;
    private int visitedId;
    private String title;
    private String content;
    private double rating;
    private Date timestamp;

    public Review(int reviewId, int visitedId, @NotNull String title, @NotNull String content, double rating, @NotNull Date timestamp) {
        this.timestamp = timestamp;
        this.visitedId = visitedId;
        this.reviewId = reviewId;

        checkRating(rating);
        this.rating = rating;

        setContent(content);
        setTitle(title);
    }

    public Review(int reviewId, int visitedId, String title, String content, double rating) {
        this(reviewId, visitedId, title, content, rating, new Date(System.currentTimeMillis()));
    }

    private static void checkRating(double rating) {
        if (rating < 1.0 || rating > 5.0) {
            throw new RuntimeException("Rating cannot be lower than 1.0 or higher than 5.0");
        }
    }

    public void setContent(@NotNull String content) {
        if (content.length() > CONTENT_MAX_LENGTH) {
            throw new RuntimeException("Content cannot be bigger than " + CONTENT_MAX_LENGTH);
        }
        if (this.content != null) {
            timestamp = new Date(System.currentTimeMillis());
        }
        this.content = content;
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new RuntimeException("Title cannot be bigger than " + TITLE_MAX_LENGTH);
        }
        if (this.title != null) {
            timestamp = new Date(System.currentTimeMillis());
        }
        this.title = title;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getVisitedId() {
        return visitedId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public double getRating() {
        return rating;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", visitedId=" + visitedId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                '}';
    }
}
