package com.ugandaairlines.ugair.booking.service;

import com.ugandaairlines.ugair.booking.model.Booking;

public interface IBookingService {
	
	public abstract Booking saveBooking(Booking booking);
	public abstract Iterable<Booking> findAllBookings();
	public abstract Booking findBookingById(Integer bookingId);
	public abstract void deleteBooking(Booking booking);

}
