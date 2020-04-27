package univ.stud.holiday.model.services.database.implementations;

import org.jetbrains.annotations.NotNull;
import univ.stud.holiday.model.services.database.MySqlDatabaseHoliday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseImpl<T> {
    protected Connection connection;

    protected DatabaseImpl(@NotNull Connection connection) {
        this.connection = connection;
    }

    abstract T fetchElement(ResultSet resultSet) throws SQLException;
}