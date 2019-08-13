package com.ugandaairlines.ugair.flight.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightCoastId;
    private double cost;
    @Enumerated(EnumType.STRING)
    private EFlightType flightType;
    @OneToOne
    private FlightClass flightClass;
    @OneToOne
    private Flight flight;

}
