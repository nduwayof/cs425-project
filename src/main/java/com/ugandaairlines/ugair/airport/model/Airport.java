package com.ugandaairlines.ugair.airport.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String country;
    @OneToMany(mappedBy = "departureAirport")
    List<Flight> departingFlights;
    @OneToMany(mappedBy = "arrivalAirport")
    List<Flight>arrivalFlights;

}
