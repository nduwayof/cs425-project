package com.ugandaairlines.ugair.booking.service;

import com.ugandaairlines.ugair.booking.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookingService {
	

    Booking saveBooking(Booking booking);
    Iterable<Booking> findAllBookings();
    Page<Booking> findAllBookings(int pageNo);
    Booking findBookingById(Integer bookingId);
    void deleteBooking(Booking booking);
	double calculateTotalCost(Booking booking);


}
