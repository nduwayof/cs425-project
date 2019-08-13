package com.ugandaairlines.ugair.flight.model;

import com.ugandaairlines.ugair.airport_aircraft.model.Aircraft;
import com.ugandaairlines.ugair.airport_aircraft.model.Airport;
import com.ugandaairlines.ugair.booking.model.Booking;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @OneToOne
    private Airport departureAirport;
    @OneToOne
    private Airport arrivalAirport;
    @OneToOne
    private Aircraft aircraft;
    @OneToMany(mappedBy = "flight")
    List<FlightCost>flightCosts;
    @OneToMany(mappedBy = "flight")
    List<Booking> bookings;

}
