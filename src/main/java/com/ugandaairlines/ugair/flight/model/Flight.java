package com.ugandaairlines.ugair.flight.model;

import com.ugandaairlines.ugair.airport.model.Aircraft;
import com.ugandaairlines.ugair.airport.model.Airport;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @Transient
    private String departureHour;

    @Transient
    private String arrivalHour;

}
