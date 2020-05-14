package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Region implements Entity<Integer> {
    private int regionId;
    private final String name;

    public Region(int regionId, @NotNull String name) {
        this.regionId = regionId;
        this.name = name;
    }

    public Region(@NotNull String name) {
        this.name = name;
    }

    public Integer getId() {
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
