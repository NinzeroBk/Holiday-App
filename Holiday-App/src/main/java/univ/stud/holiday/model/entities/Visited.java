package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.LocalDateTime;

public class Visited {
    private final int holidayId;
    private final int attractionId;
    private LocalDateTime startDate, endDate;

    public Visited(int holidayId, int attractionId, @NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate) {
        this.attractionId = attractionId;
        this.holidayId = holidayId;
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public Visited(int holidayId, int attractionId) {
        this(holidayId, attractionId, LocalDateTime.now(), LocalDateTime.now());
    }

    public void setStartDate(@NotNull LocalDateTime startDate) {
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new RuntimeException("Start date cannot take place after endDate.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(@NotNull LocalDateTime endDate) {
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before the start date.");
        }
        this.endDate = endDate;
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
                "holidayId=" + holidayId +
                ", attractionId=" + attractionId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
