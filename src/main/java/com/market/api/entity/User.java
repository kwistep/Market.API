package com.market.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "ratingCount")
    private Integer ratingCount;

    @Column(name = "rating")
    private Double rating;

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
