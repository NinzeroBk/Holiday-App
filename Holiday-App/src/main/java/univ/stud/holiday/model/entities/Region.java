package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public class Region {
    private int regionId;
    private String name;

    public Region(int regionId, @NotNull String name) {
        this.regionId = regionId;
        this.name = name;
    }

    public int getRegionId() {
        return regionId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", name='" + name + '\'' +
                '}';
    }
}
