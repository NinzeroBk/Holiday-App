package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Location {
    private final String city;
    private final int countryId;
    private final int locationId;
    private final String streetAddress;
    private final String stateProvince;

    public Location(int locationId, int countryId, @NotNull String streetAddress, @NotNull String city, @NotNull String stateProvince) {
        this.streetAddress = streetAddress;
        this.stateProvince = stateProvince;
        this.locationId = locationId;
        this.countryId = countryId;
        this.city = city;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", countryId=" + countryId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
