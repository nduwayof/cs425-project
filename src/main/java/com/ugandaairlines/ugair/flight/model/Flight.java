package com.ugandaairlines.ugair.flight.model;

import com.ugandaairlines.ugair.airport.model.Aircraft;
import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.booking.model.Booking;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @OneToOne
    private Airport departureAirport;

    @OneToOne
    private Airport arrivalAirport;

    @OneToOne
    private Aircraft aircraft;

    @Transient
    private String departureHour;

    @Transient
    private String arrivalHour;

}
