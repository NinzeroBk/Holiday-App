package univ.stud.holiday.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Converter {
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
            .withLocale(Locale.US);

    private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            .withLocale(Locale.US);

    private Converter() {
        throw new AssertionError();
    }

    public static LocalDate toLocalDate(String text) {
        return LocalDate.parse(text, LOCAL_DATE_FORMATTER);
    }

    public static String fromLocalDate(LocalDate localDate) {
        return LOCAL_DATE_FORMATTER.format(localDate);
    }

    public static LocalDateTime toLocalDateTime(String text) {
        return LocalDateTime.parse(text, LOCAL_DATE_TIME_FORMATTER);
    }

    public static String fromLocalDateTime(LocalDateTime localDateTime) {
        return LOCAL_DATE_TIME_FORMATTER.format(localDateTime);
    }
}
