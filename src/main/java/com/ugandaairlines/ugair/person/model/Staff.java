package com.ugandaairlines.ugair.person.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Staff extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    private String position;
}
