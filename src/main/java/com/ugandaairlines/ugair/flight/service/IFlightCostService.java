package com.ugandaairlines.ugair.flight.service;

import com.ugandaairlines.ugair.flight.model.FlightCost;

public interface IFlightCostService {
	
	public abstract FlightCost saveFlightCost(FlightCost flightCost);
	public abstract Iterable<FlightCost> findAllFlightCosts();
	public abstract FlightCost findFlightCostById(Integer flightCostId);
	public abstract void deleteFlightCost(FlightCost flightCost);

}
