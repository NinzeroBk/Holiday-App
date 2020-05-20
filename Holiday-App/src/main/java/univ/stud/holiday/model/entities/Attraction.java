package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Attraction implements Entity<Integer> {
    public static final int NAME_MAX_LENGTH = 25;
    public static final int DESCRIPTION_MAX_LENGTH = 75;

    private final String description;
    private final double baseCost;
    private final int locationId;
    private final String name;
    private int attractionId;
    private final int year;

    public Attraction(@NotNull String description, double baseCost, int locationId, @NotNull String name, int year) {
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

        if (year < 0) {
            runtimeException.addSuppressed(new IllegalArgumentException("Year cannot be negative!"));
        }

        if (runtimeException.getSuppressed().length != 0) {
            throw runtimeException;
        }

        this.description = description;
        this.locationId = locationId;
        this.baseCost = baseCost;
        this.name = name;
        this.year = year;
    }

    public Attraction(int attractionId, String description, double baseCost, int locationId, String name, int year) {
        this(description, baseCost, locationId, name, year);
        this.attractionId = attractionId;
    }

    public Integer getId() {
        return attractionId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLocationId() {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Attraction)) {
            return false;
        }
        Attraction attraction = (Attraction) o;
        return attractionId == attraction.attractionId;
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
