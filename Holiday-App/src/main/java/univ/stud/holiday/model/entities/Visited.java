package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class Visited {
    private int holidayId, attractionId;
    private Date startDate, endDate;

    public Visited(int holidayId, int attractionId, @NotNull Date startDate, @NotNull Date endDate) {
        this.attractionId = attractionId;
        this.holidayId = holidayId;
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public Visited(int holidayId, int attractionId) {
        this(holidayId, attractionId, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
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

    public int getAttractionId() {
        return attractionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getHolidayId() {
        return holidayId;
    }

    public Date getEndDate() {
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
