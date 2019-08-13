package com.ugandaairlines.ugair.airport.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer aircraftId;
    private String registrationCode;
    private String aircraftModel;
    private int ec_capacity;//economy class capacity
    private int bc_capacity;//business class capacity
   @OneToMany(mappedBy = "aircraft")
    List<Flight>flights;


}
