package univ.stud.holiday.gui.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class DateUtil {

    private static final String DATE_PATTERN = "dd.MM.yyyy";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private DateUtil() {
        throw new RuntimeException("Cannot instantiate this class. It's a static utility class.");
    }

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_TIME_FORMATTER.format(date);
    }

    public static LocalDate parse(String dateString) {
        try {
            return DATE_TIME_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean isDateValid(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}
