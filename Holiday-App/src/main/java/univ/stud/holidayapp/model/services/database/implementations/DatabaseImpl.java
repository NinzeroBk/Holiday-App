package univ.stud.holidayapp.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holidayapp.model.services.database.MySqlDatabaseHoliday;

public abstract class DatabaseImpl {
    protected MySqlDatabaseHoliday mySqlDatabase;

    protected DatabaseImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        this.mySqlDatabase = mySqlDatabase;
    }
}
