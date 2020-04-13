package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Country {
    public static final int NAME_MAX_LENGTH = 60;

    private final int countryId;
    private final int regionId;
    private final String name;

    public Country(int countryId, int regionId, @NotNull String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name cannot be bigger than " + NAME_MAX_LENGTH + " characters.");
        }
        this.countryId = countryId;
        this.regionId = regionId;
        this.name = name;
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
