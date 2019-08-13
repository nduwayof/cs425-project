package com.ugandaairlines.ugair.person.model;

import javax.persistence.*;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;    private String firstName;
    private String middleName;
    private String lastName;
    private EGender gender;
    private String phoneNumber;
    private String email;
    //private Address address// to decide if we are having a entity or keeping it as string


}
