package com.ugandaairlines.ugair.flight.service;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.flight.model.Flight;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IFlightService {
	
	 Flight saveFlight(Flight flight);
	 Iterable<Flight> findAllFlights();
	 Page<Flight> findAllFlights(int pageNo);
	 Flight findFlightById(Integer flightId);
	 void deleteFlight(Flight flight);
	 Iterable<Flight> flightBookingSearch(Airport depatureAirport, Airport arrivalAirport,LocalDateTime dapertureDate,LocalDateTime arrivalDate );

	Page<Flight> search(String search, int pageno);
}
