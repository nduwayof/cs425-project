package com.ugandaairlines.ugair.airport_aircraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.airport_aircraft.model.Aircraft;

@Repository
public interface IAircraftRepository extends JpaRepository<Aircraft, Integer>{

}
