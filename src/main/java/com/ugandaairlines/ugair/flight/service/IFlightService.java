package com.ugandaairlines.ugair.flight.service;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.flight.model.Flight;

import java.time.LocalDateTime;

public interface IFlightService {
	
	public abstract Flight saveFlight(Flight flight);
	public abstract Iterable<Flight> findAllFlights();
	public abstract Flight findFlightById(Integer flightId);
	public abstract void deleteFlight(Flight flight);
	public abstract Iterable<Flight> flightBookingSearch(Airport depatureAirport, Airport arrivalAirport,LocalDateTime dapertureDate,LocalDateTime arrivalDate );

}
