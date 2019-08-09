package com.market.api.controller;

import com.market.api.entity.Review;
import com.market.api.exception.ReviewNotFoundException;
import com.market.api.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews()
    {
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable(name = "id") Long id) throws ReviewNotFoundException {
        Review review = reviewService.getReview(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review review)
    {
        Review savedReview = reviewService.addReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity deleteReview(@PathVariable(name = "id") Long id) throws ReviewNotFoundException {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable(name = "id") Long id)
    {
        Review updatedReview = reviewService.updateReview(review, id);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

}
