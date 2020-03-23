package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public class User {
    public static final int PASSWORD_LOWER_BOUND = 6;
    public static final int PASSWORD_UPPER_BOUND = 20;

    private String username;
    private String password;
    private String imageUrl;
    private String emailAddress;
    private String firstName, lastName;

    public User(@NotNull String username, @NotNull String password, String imageUrl, @NotNull String emailAddress, @NotNull String firstName, @NotNull String lastName) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.imageUrl = imageUrl;
        setPassword(password);
    }

    public void setPassword(@NotNull String password) {
        if (password.length() < PASSWORD_LOWER_BOUND || password.length() > PASSWORD_UPPER_BOUND) {
            throw new RuntimeException("Password length must be between " + PASSWORD_LOWER_BOUND + " and " + PASSWORD_UPPER_BOUND + ".");
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
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
