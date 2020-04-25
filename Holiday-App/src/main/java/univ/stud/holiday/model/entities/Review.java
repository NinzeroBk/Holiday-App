package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Review {
    public static final int TITLE_MAX_LENGTH = 25;
    public static final int CONTENT_MAX_LENGTH = 250;

    private String title;
    private double rating;
    private String content;
    private final int reviewId;
    private final int visitedId;
    private final LocalDateTime timestamp;

    public Review(int reviewId, int visitedId, @NotNull String title, @NotNull String content, double rating, @NotNull LocalDateTime timestamp) {
        RuntimeException runtimeException = new RuntimeException();

        try {
            setContent(content);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        try {
            setRating(rating);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        try {
            setTitle(title);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        if (runtimeException.getSuppressed().length != 0) {
            throw runtimeException;
        }

        this.timestamp = timestamp;
        this.visitedId = visitedId;
        this.reviewId = reviewId;
    }

    public Review(int reviewId, int visitedId, String title, String content, double rating) {
        this(reviewId, visitedId, title, content, rating, LocalDateTime.now());
    }

    public void setRating(double rating) {
        if (rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating cannot be lower than 1.0 or higher than 5.0");
        }
        this.rating = rating;
    }

    public void setContent(@NotNull String content) {
        if (content.length() > CONTENT_MAX_LENGTH) {
            throw new IllegalArgumentException("Content cannot have more than " + CONTENT_MAX_LENGTH + "  characters.");
        }
        this.content = content;
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("Title cannot have more than " + TITLE_MAX_LENGTH + " characters.");
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

    public LocalDateTime getTimestamp() {
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
