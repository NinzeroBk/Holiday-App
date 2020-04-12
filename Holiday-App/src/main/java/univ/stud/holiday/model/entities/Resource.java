package univ.stud.holiday.model.entities;


import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.LocalDateTime;

public class Resource {
    public static final int TITLE_MAX_LENGTH = 25;

    private int resourceId;
    private int visitedId;
    private String title;
    private String imageUrl;
    private LocalDateTime timestamp;

    public Resource(int resourceId, int visitedId, @NotNull String title, @NotNull String imageUrl, @NotNull LocalDateTime timestamp) {
        this.resourceId = resourceId;
        this.visitedId = visitedId;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        setTitle(title);
    }

    public Resource(int resourceId, int visitedId, String title, String imageUrl) {
        this(resourceId, visitedId, title, imageUrl, LocalDateTime.now());
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new RuntimeException("Title cannot be bigger than " + TITLE_MAX_LENGTH);
        }
        this.title = title;
    }

    public int getResourceId() {
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
