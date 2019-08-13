package com.ugandaairlines.ugair.flight.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FlightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flightClassId;
    private String flightClassName;
    @OneToMany(mappedBy = "flightClass")
    List<FlightCost> flightCosts;


}
