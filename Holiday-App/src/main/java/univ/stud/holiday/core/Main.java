package univ.stud.holiday.core;

import univ.stud.holiday.model.entities.Holiday;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

public class Main {
    public static void main(String[] args) {
      MySqlDatabaseHoliday
                .getInstance()
                .holidayDao()
                .createElement(new Holiday(
                        "TitluTest",
                        "TestUser",
                        "JavaTestHoliday"
                ));
    }
}