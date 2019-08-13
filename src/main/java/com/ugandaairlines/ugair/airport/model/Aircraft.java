package com.ugandaairlines.ugair.airport.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftId;
    private String registrationCode;
    private String aircraftModel;
    private int economyCapacity;//economy class capacity
    private int businessCapacity;//business class capacity



}
