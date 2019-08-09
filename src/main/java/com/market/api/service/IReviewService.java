package com.market.api.service;

import com.market.api.entity.Review;
import com.market.api.exception.ReviewNotFoundException;

import java.util.List;

public interface IReviewService {

    List<Review> getAllReviews();

    Review getReview(Long id) throws ReviewNotFoundException;

    Review addReview(Review review);

    void deleteReviewById(Long id) throws ReviewNotFoundException;

    Review updateReview(Review review, Long id);

}
