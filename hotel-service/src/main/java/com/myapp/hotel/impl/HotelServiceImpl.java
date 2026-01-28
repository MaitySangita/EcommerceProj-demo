package com.myapp.hotel.impl;

import com.myapp.hotel.entities.Hotel;
import com.myapp.hotel.exception.ResourceNotFoundException;
import com.myapp.hotel.repository.HotelRepository;
import com.myapp.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository repository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    @Override
    public Hotel updateHotel(String id, Hotel updatedHotel) {
        Hotel existingHotel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + id));

        existingHotel.setName(updatedHotel.getName());
        existingHotel.setLocation(updatedHotel.getLocation());
        existingHotel.setAbout(updatedHotel.getAbout());

        return repository.save(existingHotel);
    }

    @Override
    public void deleteHotel(String hotelId) {

        if (!repository.existsById(hotelId)) {
            throw new ResourceNotFoundException("Hotel not found with ID: " + hotelId);
        }
        repository.deleteById(hotelId);

    }
}
