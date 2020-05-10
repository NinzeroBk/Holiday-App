package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public final class Resource implements Entity<Integer> {
    public static final int TITLE_MAX_LENGTH = 25;

    private String title;
    private int resourceId;
    private final int visitedId;
    private final String imageUrl;
    private final LocalDateTime timestamp;

    public Resource(int resourceId, int visitedId, @NotNull String title, @NotNull String imageUrl, @NotNull LocalDateTime timestamp) {
        this(visitedId, title, imageUrl, timestamp);
        this.resourceId = resourceId;
    }

    public Resource(int visitedId, @NotNull String title, @NotNull String imageUrl, @NotNull LocalDateTime timestamp) {
        this.setTitle(title);
        this.visitedId = visitedId;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
    }

    public Resource(int resourceId, int visitedId, String title, String imageUrl) {
        this(visitedId, title, imageUrl);
        this.resourceId = resourceId;
    }

    public Resource(int visitedId, String title, String imageUrl) {
        this(visitedId, title, imageUrl, LocalDateTime.now());
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("Title cannot have more than " + TITLE_MAX_LENGTH + " characters.");
        }
        this.title = title;
    }

    public Integer getId() {
        return resourceId;
    }

    public int getVisitedId() {
        return visitedId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", visitedId=" + visitedId +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
