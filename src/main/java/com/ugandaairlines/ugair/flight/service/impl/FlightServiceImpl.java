package com.ugandaairlines.ugair.flight.service.impl;

import com.ugandaairlines.ugair.airport.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.repository.IFlightRepository;
import com.ugandaairlines.ugair.flight.service.IFlightService;

import java.time.LocalDateTime;

@Service
public class FlightServiceImpl implements IFlightService {
	
	@Autowired
	private IFlightRepository flightRepository;

	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Iterable<Flight> findAllFlights() {

		return flightRepository.findAll();
	}
	@Override
	public Page<Flight> findAllFlights(int pageNo) {
		return flightRepository.findAll(PageRequest.of(pageNo,5,Sort.by("arrivalTime")));
	}
	@Override
	public Flight findFlightById(Integer flightId) {

		return flightRepository.findById(flightId).orElse(null);
	}
	@Override
	public void deleteFlight(Flight flight) {
		flightRepository.delete(flight);
			}
	@Override
	public Iterable<Flight> flightBookingSearch(Airport depatureAirport, Airport arrivalAirport, LocalDateTime dapertureDate, LocalDateTime arrivalDate) {
		return flightRepository.flightBookingSearch(depatureAirport, arrivalAirport, dapertureDate, arrivalDate);
	}
	@Override
	public Page<Flight> search(String search, int pageno) {
		return flightRepository.findFlightsByFlightNumberContainingOrArrivalAirportCityContainingOrDepartureAirportCityOrDepartureAirportAirportNameContainingOrArrivalAirportAirportNameContainingOrDepartureAirportCountryContainingOrArrivalAirportCountryContainingOrAircraftAircraftModelContainingOrAircraftRegistrationCodeContaining(search, search,search,search,search,search,search,search,search,PageRequest.of(pageno,5, Sort.by("flightNumber")));
	}

}
