package univ.stud.holiday.core;

import univ.stud.holiday.model.HolidayRepository;
import univ.stud.holiday.model.entities.Attraction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Attraction> attractionList = HolidayRepository
                .getInstance()
                .getDataSource()
                .attractionDao()
                .getElements();
    }
}