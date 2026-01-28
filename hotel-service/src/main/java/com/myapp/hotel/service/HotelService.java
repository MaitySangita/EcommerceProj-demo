package com.myapp.hotel.service;


import com.myapp.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAllHotels();


    //getSingle
    Hotel getHotel(String hotelId);


    //update
    Hotel updateHotel(String hotelId, Hotel updatedHotel);


    //delete
    void deleteHotel(String hotelId);

}
