package com.ugandaairlines.ugair.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.booking.model.Booking;
import com.ugandaairlines.ugair.booking.repository.IBookingRepository;
import com.ugandaairlines.ugair.booking.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Iterable<Booking> findAllBookings() {

		return bookingRepository.findAll();
	}

	@Override
	public Booking findBookingById(Integer bookingId) {

		return bookingRepository.findById(bookingId).orElse(null);
	}

	@Override
	public void deleteBooking(Booking booking) {
		bookingRepository.delete(booking);
		
	}

}