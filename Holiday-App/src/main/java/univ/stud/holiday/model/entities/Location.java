package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Location implements Entity<Integer> {
    private int locationId;
    private final String city;
    private final int countryId;
    private final String streetAddress;
    private final String stateProvince;

    public Location(int countryId, @NotNull String streetAddress, @NotNull String city, @NotNull String stateProvince) {
        this.streetAddress = streetAddress;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
        this.city = city;
    }

    public Location(int locationId, int countryId, String streetAddress, String city, String stateProvince) {
        this(countryId, streetAddress, city, stateProvince);
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public int getCountryId() {
        return countryId;
    }

    public Integer getId() {
        return locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
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
