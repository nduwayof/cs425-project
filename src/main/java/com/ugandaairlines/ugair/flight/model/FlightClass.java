package com.ugandaairlines.ugair.flight.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightClassId;
    private String flightClassName;
}
