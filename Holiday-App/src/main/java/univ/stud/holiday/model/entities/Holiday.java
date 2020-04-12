package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.LocalDate;

public class Holiday {
    public static final int TITLE_MAX_LENGTH = 25;
    public static final int DESCRIPTION_MAX_LENGTH = 100;

    private String title;
    private String description;
    private final int holidayId;
    private final String username;
    private LocalDate startDate, endDate;

    public Holiday(int holidayId, @NotNull String title, @NotNull String username, String description, @NotNull LocalDate startDate, @NotNull LocalDate endDate) {
        checkUsername(username);
        this.username = username;
        this.holidayId = holidayId;
        setDescription(description);
        setStartDate(startDate);
        setEndDate(endDate);
        setTitle(title);
    }

    public Holiday(int holidayId, String title, String username, String description) {
        this(holidayId, title, username, description, LocalDate.now(), LocalDate.now());
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new RuntimeException("Title cannot be bigger than ");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new RuntimeException("Description cannot be bigger than ");
        }
        this.description = description;
    }

    public void setStartDate(@NotNull LocalDate startDate) {
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new RuntimeException("Start date cannot take place after endDate.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull LocalDate endDate) {
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before the start date.");
        }
        this.endDate = endDate;
    }

    private static void checkUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null.");
        }
    }

    public int getHolidayId() {
        return holidayId;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "holidayId=" + holidayId +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
