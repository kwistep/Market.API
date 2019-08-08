package com.market.api.service;

import com.market.api.entity.Review;

import java.util.List;

public interface IReviewService {

    List<Review> getAllReviews();

    Review getReview(Long id);

    Review addReview(Review review);

    void deleteReviewById(Long id);

    Review updateReview(Review review, Long id);

}
