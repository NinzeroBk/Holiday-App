package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Country {
    public static final int NAME_MAX_LENGTH = 60;

    private int countryId;
    private final String name;
    private final int regionId;

    public Country(int regionId, @NotNull String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name cannot be bigger than " + NAME_MAX_LENGTH + " characters.");
        }
        this.regionId = regionId;
        this.name = name;
    }

    public Country(int countryId, int regionId, String name) {
        this(regionId, name);
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getRegionId() {
        return regionId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", regionId=" + regionId +
                ", name='" + name + '\'' +
                '}';
    }
}
