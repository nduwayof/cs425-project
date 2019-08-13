package com.ugandaairlines.ugair.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.flight.model.FlightCost;
import com.ugandaairlines.ugair.flight.repository.IFlightCostRepository;
import com.ugandaairlines.ugair.flight.service.IFlightCostService;

@Service
public class FlightCostServiceImpl implements IFlightCostService {
	
	@Autowired
	private IFlightCostRepository flightCostRepository;

	@Override
	public FlightCost saveFlightCost(FlightCost flightCost) {
		return flightCostRepository.save(flightCost);
	}

	@Override
	public Iterable<FlightCost> findAllFlightCosts() {

		return flightCostRepository.findAll();
	}

	@Override
	public FlightCost findFlightCostById(Integer flightCostId) {

		return flightCostRepository.findById(flightCostId).orElse(null);
	}

	@Override
	public void deleteFlightCost(FlightCost flightCost) {
		flightCostRepository.delete(flightCost);
		
	}

}
