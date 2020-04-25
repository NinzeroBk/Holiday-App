package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DatabaseImpl {
    protected MySqlDatabaseHoliday mySqlDatabase;

    protected DatabaseImpl(@NotNull MySqlDatabaseHoliday mySqlDatabase) {
        this.mySqlDatabase = mySqlDatabase;
    }
}