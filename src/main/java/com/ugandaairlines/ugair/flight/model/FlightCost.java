package com.ugandaairlines.ugair.flight.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flightCoastId;
    @OneToOne
    private FlightClass flightClass;
    @OneToOne
    private Flight flight;
    private double cost;

}
