package com.ugandaairlines.ugair.airport.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "aircrafts")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftId;
    private String registrationCode;
    private String aircraftModel;
    private int economyCapacity;
    private int businessCapacity;
    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights;

}
