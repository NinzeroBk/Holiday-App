package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public final class Visited {
    private int visitedId;
    private final int holidayId;
    private final int attractionId;
    private LocalDateTime startDate, endDate;

    public Visited(int holidayId, int attractionId, @NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate) {
        setDates(startDate, endDate);
        this.attractionId = attractionId;
        this.holidayId = holidayId;
    }

    public Visited(int visitedId, int holidayId, int attractionId, LocalDateTime startDate, LocalDateTime endDate) {
        this(holidayId, attractionId, startDate, endDate);
        this.visitedId = visitedId;
    }

    public Visited(int holidayId, int attractionId) {
        this(holidayId, attractionId, LocalDateTime.now(), LocalDateTime.now());
    }

    public void setDates(@NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date!");
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public void setStartDate(@NotNull LocalDateTime startDate) {
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot take place after endDate.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull LocalDateTime endDate) {
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before the start date.");
        }
        this.endDate = endDate;
    }

    public int getVisitedId() {
        return visitedId;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int getHolidayId() {
        return holidayId;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Visited{" +
                "visitedId=" + visitedId +
                ", holidayId=" + holidayId +
                ", attractionId=" + attractionId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
