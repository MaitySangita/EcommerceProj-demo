package com.myapp.rating_service.impl;

import com.myapp.rating_service.entities.Rating;
import com.myapp.rating_service.repository.RatingRepository;
import com.myapp.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;

    @Autowired
    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }


    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating updatedRating) {
        Rating r1= repository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " +ratingId));

        r1.setRating(updatedRating.getRating());
        r1.setFeedback(updatedRating.getFeedback());

        return repository.save(r1);
    }

    @Override
    public void deleteRating(String ratingId) {

        if (!repository.existsById(ratingId)) {
            throw new RuntimeException("Rating not found with ID: " + ratingId);
        }
        repository.deleteById(ratingId);
    }
}
