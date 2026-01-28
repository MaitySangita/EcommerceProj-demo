package com.myapp.rating_service.controller;


import com.myapp.rating_service.entities.Rating;
import com.myapp.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService service;

    @Autowired
    public RatingController(RatingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        Rating rating1 =service.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){

        return ResponseEntity.ok(service.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){

        return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating updatedRating){

        Rating rating = service.updateRating(ratingId, updatedRating);
        return ResponseEntity.ok(rating);
    }

    @DeleteMapping("/ratings/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable String ratingId) {
        service.deleteRating(ratingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Rating deleted successfully with ID: " + ratingId);
    }




}
