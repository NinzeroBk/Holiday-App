package univ.stud.holidayapp.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class Holiday {
    public static final int TITLE_MAX_LENGTH = 25;
    public static final int DESCRIPTION_MAX_LENGTH = 100;

    private int holidayId;
    private String title;
    private String username;
    private String description;
    private Date startDate, endDate;

    public Holiday(int holidayId, @NotNull String title, @NotNull String username, String description, @NotNull Date startDate, @NotNull Date endDate) {
        checkUsername(username);
        this.username = username;
        this.holidayId = holidayId;
        setDescription(description);
        setStartDate(startDate);
        setEndDate(endDate);
        setTitle(title);
    }

    public Holiday(int holidayId, String title, String username, String description) {
        this(holidayId, title, username, description, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
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

    public void setStartDate(@NotNull Date startDate) {
        if (endDate != null && startDate.after(endDate)) {
            throw new RuntimeException("Start date cannot take place after endDate.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull Date endDate) {
        if (startDate != null && endDate.before(startDate)) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
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
