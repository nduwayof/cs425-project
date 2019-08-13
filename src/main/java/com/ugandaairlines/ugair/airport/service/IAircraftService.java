package com.ugandaairlines.ugair.airport.service;

import com.ugandaairlines.ugair.airport.model.Aircraft;

public interface IAircraftService {
	
	public abstract Aircraft saveAircraft(Aircraft aircraft);
	public abstract Iterable<Aircraft> findAllAircrafts();
	public abstract Aircraft findAircraftById(Integer integer);
	public abstract void deleteAircraft(Aircraft aircraft);

}
