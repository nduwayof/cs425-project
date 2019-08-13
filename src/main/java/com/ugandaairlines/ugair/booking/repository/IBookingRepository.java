package com.ugandaairlines.ugair.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.booking.model.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {

}
