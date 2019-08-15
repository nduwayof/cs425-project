package com.ugandaairlines.ugair.person.service.impl;

import com.ugandaairlines.ugair.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.person.model.Passenger;
import com.ugandaairlines.ugair.person.repository.IPassengerRepository;
import com.ugandaairlines.ugair.person.service.IPassengerService;

@Service
public class PassengerServiceImpl implements IPassengerService {
	
	@Autowired
	private IPassengerRepository passengerRepository;

	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public Iterable<Passenger> findAllPassengers() {

		return passengerRepository.findAll();
	}

	@Override
	public Passenger findPassengerById(Integer passengerId) {

		return passengerRepository.findById(passengerId).orElse(null);
	}

	@Override
	public void deletePassenger(Passenger passenger) {
		passengerRepository.delete(passenger);
		
	}

	@Override
	public Iterable<Passenger> findPassegersByBooking(Booking booking) {
		return passengerRepository.findAllByBookingEquals(booking);
	}

}
