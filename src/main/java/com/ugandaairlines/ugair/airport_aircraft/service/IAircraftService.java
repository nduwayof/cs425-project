package com.ugandaairlines.ugair.airport_aircraft.service;

import com.ugandaairlines.ugair.airport_aircraft.model.Aircraft;

public interface IAircraftService {
	
	public abstract Aircraft saveAircraft(Aircraft aircraft);
	public abstract Iterable<Aircraft> findAllAircrafts();
	public abstract Aircraft findAircraftById(Integer integer);
	public abstract void deleteAircraft(Aircraft aircraft);

}
