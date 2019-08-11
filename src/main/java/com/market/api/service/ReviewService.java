package com.market.api.service;

import com.market.api.entity.Review;
import com.market.api.entity.User;
import com.market.api.entity.util.Status;
import com.market.api.exception.ReviewNotFoundException;
import com.market.api.exception.UserNotFoundException;
import com.market.api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private IUserService userService;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) throws ReviewNotFoundException {
        Optional<Review> targetReview = reviewRepository.findById(id);

        if( targetReview.isPresent() )
        {
            return targetReview.get();
        }
        else
        {
            throw new ReviewNotFoundException("Review [" + id + "] doesn't exist.");
        }
    }

    @Override
    public Review addReview(Review review, Long userId) throws UserNotFoundException {
        User currentUser = userService.getUser(userId);
        review.setCreatedBy(currentUser);
        review.setStatus(Status.NEW.getStatus());
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(Long id) throws ReviewNotFoundException {
        Optional<Review> targetReview = reviewRepository.findById(id);

        if( targetReview.isPresent() )
        {
            Review review = targetReview.get();
            reviewRepository.delete(review);
                   }
        else
        {
           throw new ReviewNotFoundException("Review [" + id + "] doesn't exist.");
        }
    }

    @Override
    public Review updateReview(Review review, Long id) {
        review.setReviewId(id);
        return reviewRepository.save(review);
    }

    public void publishReview(Long id) throws ReviewNotFoundException {
        Optional<Review> targerReview = reviewRepository.findById(id);

        if( targerReview.isPresent() )
        {
            Review review = targerReview.get();
            review.setStatus(Status.PUBLISHED.getStatus());
            reviewRepository.save(review);
        }
        else
        {
            throw new ReviewNotFoundException("Review [" + id + "] doesn't exist.");
        }
    }
}
