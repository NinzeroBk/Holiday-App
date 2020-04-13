package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Attraction {
    private static final int NAME_MAX_LENGTH = 25;
    private static final int DESCRIPTION_MAX_LENGTH = 75;

    private final String description;
    private final int attractionId;
    private final double baseCost;
    private final int locationId;
    private final String name;
    private final int year;

    public Attraction(@NotNull String description, int attractionId, double baseCost, int locationId, @NotNull String name, int year) {
        RuntimeException runtimeException = new RuntimeException();

        if (baseCost < 0) {
            runtimeException.addSuppressed(new IllegalArgumentException("Base cost cannot be negative!"));
        }

        if (name.length() > NAME_MAX_LENGTH) {
            runtimeException.addSuppressed(new IllegalArgumentException("Name length is bigger than " + NAME_MAX_LENGTH + " characters."));
        }

        if (description.length() > DESCRIPTION_MAX_LENGTH) {
            runtimeException.addSuppressed(new IllegalArgumentException("Description length is bigger than " + DESCRIPTION_MAX_LENGTH + " characters."));
        }

        if (runtimeException.getSuppressed().length != 0) {
            throw runtimeException;
        }

        this.attractionId = attractionId;
        this.description = description;
        this.locationId = locationId;
        this.baseCost = baseCost;
        this.name = name;
        this.year = year;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public String getDescription() {
        return description;
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
