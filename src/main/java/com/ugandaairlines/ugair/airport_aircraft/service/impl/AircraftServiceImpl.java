package com.ugandaairlines.ugair.airport_aircraft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.airport_aircraft.model.Aircraft;
import com.ugandaairlines.ugair.airport_aircraft.repository.IAircraftRepository;
import com.ugandaairlines.ugair.airport_aircraft.service.IAircraftService;

@Service
public class AircraftServiceImpl implements IAircraftService {
	
	@Autowired
	private IAircraftRepository aircraftRepository;

	@Override
	public Aircraft saveAircraft(Aircraft aircraft) {
		return aircraftRepository.save(aircraft);
	}

	@Override
	public Iterable<Aircraft> findAllAircrafts() {
		
		return aircraftRepository.findAll();
	}

	@Override
	public Aircraft findAircraftById(Integer aircraftId) {
		
		return aircraftRepository.findById(aircraftId).orElse(null);
	}

	@Override
	public void deleteAircraft(Aircraft aircraft) {
		aircraftRepository.delete(aircraft);
		
	}

}
