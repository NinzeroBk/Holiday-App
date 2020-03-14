package univ.stud.holidayapp.model.entities;

import org.jetbrains.annotations.NotNull;

public class Country {
    public static final int NAME_MAX_LENGTH = 60;

    private int countryId;
    private int regionId;
    private String name;

    public Country(int countryId, int regionId, @NotNull String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException("Name cannot be bigger than " + name);
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
