package com.market.api.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long userId;

    @NotBlank(message = "Login cannot be empty.")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Password cannot be empty.")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "First name cannot be empty.")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Surname cannot be empty.")
    @Column(name = "surname")
    private String surname;

    //TODO create the pattern
//    @Pattern()
    @NotBlank(message = "Phone number cannot be empty.")
    @Column(name = "phoneNumber")
    private String phoneNumber;

//    TODO check how it works
    @Email(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email should be valid!")
    @Column(name = "email")
    private String email;

    @Min(value = 0, message = "Rating count cannot be less than 0.")
    @Max(value = 2_147_483_647, message = "Rating count cannot be more than 2147483647.")
    @Column(name = "ratingCount")
    private Integer ratingCount;

    @DecimalMin(value = "0.0", message = "Rating cannot be less than 0.0")
    @Column(name = "rating")
    private Double rating;

    @PastOrPresent(message = "Registration date cannot be future.")
    @Column(name = "registered")
    private LocalDateTime registered;


    @OneToMany(mappedBy = "attachedTo")
    private List<Review> reviews;

    @OneToMany(mappedBy = "seller")
    private List<Product> soldProducts;

    @OneToMany(mappedBy = "buyer")
    private List<Product> boughtProducts;

    @OneToMany(mappedBy = "attachedTo")
    private List<ProductOrder> orders;

    public User() {
    }

    public User(Long userId, String login, String password, String firstName, String surname, String phoneNumber, String email, Integer ratingCount, Double rating, LocalDateTime registered) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ratingCount = ratingCount;
        this.rating = rating;
        this.registered = registered;
    }

    @PrePersist
    void prePersist()
    {
        this.registered = LocalDateTime.now();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                firstName.equals(user.firstName) &&
                surname.equals(user.surname) &&
                phoneNumber.equals(user.phoneNumber) &&
                email.equals(user.email) &&
                ratingCount.equals(user.ratingCount) &&
                rating.equals(user.rating) &&
                registered.equals(user.registered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, firstName, surname, phoneNumber, email, ratingCount, rating, registered);
    }
}
