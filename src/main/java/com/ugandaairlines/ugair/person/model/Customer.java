package com.ugandaairlines.ugair.person.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Person {
    //do we need this class and for passengers/just for persistence and relationships
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
}
