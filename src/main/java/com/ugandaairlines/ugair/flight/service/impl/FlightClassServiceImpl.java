package com.ugandaairlines.ugair.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.flight.model.FlightClass;
import com.ugandaairlines.ugair.flight.repository.IFlightClassRepository;
import com.ugandaairlines.ugair.flight.service.IFlightClassService;


@Service
public class FlightClassServiceImpl implements IFlightClassService {
	
	@Autowired
	private IFlightClassRepository flightClassRepository;

	@Override
	public FlightClass saveFlightClass(FlightClass FlightClass) {
		return flightClassRepository.save(FlightClass);
	}

	@Override
	public Iterable<FlightClass> findAllFlightClasses() {

		return flightClassRepository.findAll();
	}

	@Override
	public FlightClass findFlightClassById(Integer FlightClassId) {

		return flightClassRepository.findById(FlightClassId).orElse(null);
	}

	@Override
	public void deleteFlightClass(FlightClass FlightClass) {
		flightClassRepository.delete(FlightClass);
		
	}

}
