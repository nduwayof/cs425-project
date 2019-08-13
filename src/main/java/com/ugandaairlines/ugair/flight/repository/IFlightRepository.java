package com.ugandaairlines.ugair.flight.repository;

import com.ugandaairlines.ugair.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.flight.model.Flight;

import java.time.LocalDateTime;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{


    //@Query(value = "select * from flight where ((DATEDIFF(departure_time,?1 ) >=0) and (DATEDIFF(arrival_time,?2) <=0)   ) and arrival_airport_airport_id = ?3 and departure_airport_airport_id = ?4   ",nativeQuery = true)
    @Query(value = "select * from flight",nativeQuery = true)
    public Iterable<Flight> flightBookingSearch(Airport depatureAirport, Airport arrivalAirport, LocalDateTime dapertureDate, LocalDateTime arrivalDate);

}
