package com.ugandaairlines.ugair.airport.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftId;
    private String registrationCode;
    private String aircraftModel;
    private int economyCapacity;
    private int businessCapacity;
}
