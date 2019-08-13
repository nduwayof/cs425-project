package com.ugandaairlines.ugair.flight.service;

import com.ugandaairlines.ugair.flight.model.Flight;

public interface IFlightService {
	
	public abstract Flight saveFlight(Flight flight);
	public abstract Iterable<Flight> findAllFlights();
	public abstract Flight findFlightById(Integer flightId);
	public abstract void deleteFlight(Flight flight);

}
