package com.ugandaairlines.ugair.airport.service;

import com.ugandaairlines.ugair.airport.model.Airport;

public interface IAirportService {
	
	public abstract Airport saveAircraft(Airport airport);
	public abstract Iterable<Airport> findAllAirport();
	public abstract Airport findAirportById(Integer integer);
	public abstract void deleteAirport(Airport airport);


}
