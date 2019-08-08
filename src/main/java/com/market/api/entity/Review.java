package com.market.api.entity;

import com.market.api.entity.util.Status;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Review")
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User attachedTo;

    @Column(name = "ratingValue")
    private Integer ratingValue;

    @Column(name = "description")
    private String description;

    @Column(name = "status", length = 9)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Review() {
    }

    public Review(Long reviewId, User createdBy, User attachedTo, Integer ratingValue, String description, Status status) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
