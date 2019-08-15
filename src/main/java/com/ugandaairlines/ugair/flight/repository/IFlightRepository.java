package com.ugandaairlines.ugair.flight.repository;

import com.ugandaairlines.ugair.airport.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.flight.model.Flight;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{


    //@Query(value = "select * from flight where ((DATEDIFF(departure_time,?1 ) >=0) and (DATEDIFF(arrival_time,?2) <=0)   ) and arrival_airport_airport_id = ?3 and departure_airport_airport_id = ?4   ",nativeQuery = true)
    @Modifying
    @Query(value = "select f from Flight  f where f.departureAirport = :departureAirport and f.arrivalAirport = :arrivalAirport and f.departureTime >= :departureTime and f.arrivalTime >= :arrivalTime   ")
    public Collection<Flight> flightBookingSearch(@Param("departureAirport") Airport depatureAirport, @Param("arrivalAirport") Airport arrivalAirport, @Param("departureTime") LocalDateTime dapertureDate, @Param("arrivalTime") LocalDateTime arrivalDate);


    public Page<Flight>
    findFlightsByFlightNumberContainingOrArrivalAirportCityContainingOrDepartureAirportCityOrDepartureAirportAirportNameContainingOrArrivalAirportAirportNameContainingOrDepartureAirportCountryContainingOrArrivalAirportCountryContainingOrAircraftAircraftModelContainingOrAircraftRegistrationCodeContaining
            (String flightNumber,String arrivalCity,String departureCity,String departureAirport,String arrivalAirport,String departureCountry,String arrivalCountry,String aircraftModel, String aircraftRegistrationCode,Pageable tName);



}
