package com.ugandaairlines.ugair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.flight.model.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{

}
