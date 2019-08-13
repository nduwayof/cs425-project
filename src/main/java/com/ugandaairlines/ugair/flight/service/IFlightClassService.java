package com.ugandaairlines.ugair.flight.service;

import com.ugandaairlines.ugair.flight.model.FlightClass;

public interface IFlightClassService {
	
	public abstract FlightClass saveFlightClass(FlightClass flightClass);
	public abstract Iterable<FlightClass> findAllFlightClasses();
	public abstract FlightClass findFlightClassById(Integer flightClassId);
	public abstract void deleteFlightClass(FlightClass flightClass);

}
