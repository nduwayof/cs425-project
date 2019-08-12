package com.ugandaairlines.ugair.person.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    private String firstName;
    private String middleName;
    private String lastName;

}
