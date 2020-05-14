package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class User implements Entity<String> {
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
    public static final int PASS_MIN = 6;
    public static final int PASS_MAX = 20;

    private final String emailAddress;
    private final String firstName;
    private final String username;
    private final String lastName;
    private String password;
    private String imageUrl;

    public User(@NotNull String username, @NotNull String password, String imageUrl, @NotNull String emailAddress, @NotNull String firstName, @NotNull String lastName) {
        RuntimeException runtimeException = new RuntimeException();

        try {
            setPassword(password);
        } catch (IllegalArgumentException illegalArgumentException) {
            runtimeException.addSuppressed(illegalArgumentException);
        }

        if (!EMAIL_PATTERN.matcher(emailAddress).matches()) {
            runtimeException.addSuppressed(new IllegalArgumentException("Invalid email address format."));
        }

        if (runtimeException.getSuppressed().length != 0) {
            throw runtimeException;
        }

        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public void setPassword(@NotNull String password) {
        if (password.length() < User.PASS_MIN || password.length() > User.PASS_MAX) {
            throw new IllegalArgumentException("Password length must be between " + User.PASS_MIN + " and " + User.PASS_MAX + ".");
        }
        this.password = password;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s, Last Name: %s, Email Address: %s", firstName, lastName, emailAddress);
    }
}
