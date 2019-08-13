package com.ugandaairlines.ugair.airport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.repository.IAirportRepository;
import com.ugandaairlines.ugair.airport.service.IAirportService;

@Service
public class AirportServiceImpl implements IAirportService {

<<<<<<< HEAD:src/main/java/com/ugandaairlines/ugair/airport/service/impl/AirportServiceImpl.java
	@Autowired
=======
>>>>>>> 9e578f1fcc2b468f37ab56db1cd6f94b9bb3781b:src/main/java/com/ugandaairlines/ugair/airport_aircraft/service/impl/AirportServiceImpl.java
	private IAirportRepository airportRepository;

	@Autowired
	public AirportServiceImpl(IAirportRepository airportRepository){
		this.airportRepository = airportRepository;
	}

	@Override
	public Airport saveAircraft(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Iterable<Airport> findAllAirport() {
		return airportRepository.findAll();
	}

	@Override
	public Airport findAirportById(Integer airportId) {
		return airportRepository.findById(airportId).orElse(null);
	}

	@Override
	public void deleteAirport(Airport airport) {
		airportRepository.delete(airport);
		
	}

}
