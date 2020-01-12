package com.mindtree.traveltourapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.traveltourapplication.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
