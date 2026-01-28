package com.myapp.hotel.controller;

import com.myapp.hotel.entities.Hotel;
import com.myapp.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = service.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    // READ (all)
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = service.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // READ (single)
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Hotel hotel = service.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    // UPDATE
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable String hotelId,
            @RequestBody Hotel updatedHotel) {

        Hotel hotel = service.updateHotel(hotelId, updatedHotel);
        return ResponseEntity.ok(hotel);
    }

    // DELETE
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {
        service.deleteHotel(hotelId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Hotel deleted successfully with ID: " + hotelId);
    }
}
