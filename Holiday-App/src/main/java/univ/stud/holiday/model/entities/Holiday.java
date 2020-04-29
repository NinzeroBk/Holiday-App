package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public final class Holiday {
    public static final int TITLE_MAX_LENGTH = 25;
    public static final int DESCRIPTION_MAX_LENGTH = 100;

    private String title;
    private int holidayId;
    private String description;
    private final String username;
    private LocalDate startDate, endDate;

    public Holiday(@NotNull String title, @NotNull String username, String description, @NotNull LocalDate startDate, @NotNull LocalDate endDate) {
        RuntimeException runtimeException = new RuntimeException();

        try {
            setDescription(description);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        try {
            setStartDate(startDate);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        try {
            setEndDate(endDate);
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

        this.username = username;
    }


    public Holiday(int holidayId, String title, String username, String description) {
        this(holidayId, title, username, description, LocalDate.now(), LocalDate.now());
    }

    public Holiday(int holidayId, String title, String username, String description, LocalDate startDate, LocalDate endDate) {
        this(title, username, description, startDate, endDate);
        this.holidayId = holidayId;
    }

    public Holiday(String title, String username, String description) {
        this(title, username, description, LocalDate.now(), LocalDate.now());
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("Title cannot be have more than " + TITLE_MAX_LENGTH + " characters.");
        }
        this.title = title;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description != null && description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException("Description cannot have more than " + DESCRIPTION_MAX_LENGTH + " characters.");
        }
        this.description = description;
    }

    public void setStartDate(@NotNull LocalDate startDate) {
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot take place after endDate.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull LocalDate endDate) {
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before the start date.");
        }
        this.endDate = endDate;
    }

    public void setDates(@NotNull LocalDate startDate, @NotNull LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot take place after endDate.");
        }
        this.endDate = endDate;
        this.startDate = startDate;
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
