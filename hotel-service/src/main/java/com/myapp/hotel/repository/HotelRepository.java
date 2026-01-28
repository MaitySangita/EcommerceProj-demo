package com.myapp.hotel.repository;

import com.myapp.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel , String> {



}
