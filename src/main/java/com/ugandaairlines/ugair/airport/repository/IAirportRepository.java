package com.ugandaairlines.ugair.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.airport.model.Airport;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, Integer> {

}
