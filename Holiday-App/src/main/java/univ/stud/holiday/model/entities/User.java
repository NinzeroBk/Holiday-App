package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class User {
    public static final int PASSWORD_LOWER_BOUND = 6;
    public static final int PASSWORD_UPPER_BOUND = 20;
    private static final Pattern emailPattern = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

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

        if (!emailPattern.matcher(emailAddress).matches()) {
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
        if (password.length() < User.PASSWORD_LOWER_BOUND || password.length() > User.PASSWORD_UPPER_BOUND) {
            throw new IllegalArgumentException("Password length must be between " + User.PASSWORD_LOWER_BOUND + " and " + User.PASSWORD_UPPER_BOUND + ".");
        }
        this.password = password;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
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
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
