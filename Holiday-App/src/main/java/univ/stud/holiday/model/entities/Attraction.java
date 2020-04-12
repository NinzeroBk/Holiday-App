package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public class Attraction {
    public static final int NAME_MAX_LENGTH = 25;
    public static final int DESCRIPTION_MAX_LENGTH = 75;

    private final String description;
    private final int attractionId;
    private final double baseCost;
    private final int locationId;
    private final String name;
    private final int year;

    public Attraction(@NotNull String description, int attractionId, double baseCost, int locationId, @NotNull String name, int year) {
        Attraction.checkConstraint(description.length() > DESCRIPTION_MAX_LENGTH, "Attraction description is bigger than " + DESCRIPTION_MAX_LENGTH);
        Attraction.checkConstraint(name.length() > NAME_MAX_LENGTH, "Name cannot be bigger than " + NAME_MAX_LENGTH);
        Attraction.checkConstraint(baseCost < 0, "Base cost cannot be negative.");
        this.attractionId = attractionId;
        this.description = description;
        this.locationId = locationId;
        this.baseCost = baseCost;
        this.name = name;
        this.year = year;
    }

    private static void checkConstraint(boolean conditionIsFalse, String errorMessage) {
        if (conditionIsFalse) {
            throw new RuntimeException(errorMessage);
        }
    }

    public int getAttractionId() {
        return attractionId;
    }

    public int getLocationId() {
        return locationId;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "attractionId=" + attractionId +
                ", locationId=" + locationId +
                ", baseCost=" + baseCost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                '}';
    }
}
