package com.myapp.rating_service.service;

import com.myapp.rating_service.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface RatingService {

    //create

    Rating create(Rating rating);


    //getAll

    List<Rating> getRatings();

    //get all rating by userId
    List<Rating> getRatingByUserId(String userId);


    //get all by hotel

    List<Rating> getRatingByHotelId(String hotelId);


    //update
    Rating updateRating(String ratingId,Rating updateRating);


    //delete
    void deleteRating(String ratingId);


}
