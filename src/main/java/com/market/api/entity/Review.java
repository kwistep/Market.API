package com.market.api.entity;

import com.market.api.entity.util.Status;
import com.market.api.validation.StatusCheck;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "Review")
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @NotNull(message = "The field cannot be empty.")
    @ManyToOne(fetch = FetchType.EAGER)
    private User attachedTo;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "5.0")
    @Column(name = "ratingValue")
    private Integer ratingValue;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @StatusCheck(value = {Status.NEW, Status.PUBLISHED})
    private String status;

    public Review() {
    }

    public Review(Long reviewId, User createdBy, User attachedTo, Integer ratingValue, String description, String status) {
        this.reviewId = reviewId;
        this.createdBy = createdBy;
        this.attachedTo = attachedTo;
        this.ratingValue = ratingValue;
        this.description = description;
        this.status = status;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(User attachedTo) {
        this.attachedTo = attachedTo;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Integer ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId.equals(review.reviewId) &&
                createdBy.equals(review.createdBy) &&
                attachedTo.equals(review.attachedTo) &&
                ratingValue.equals(review.ratingValue) &&
                description.equals(review.description) &&
                status == review.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, createdBy, attachedTo, ratingValue, description, status);
    }
}
