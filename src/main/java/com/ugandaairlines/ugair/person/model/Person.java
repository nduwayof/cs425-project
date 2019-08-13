package com.ugandaairlines.ugair.person.model;

import javax.persistence.*;

@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    private String firstName;
    private String middleName;
    private String lastName;
    private EGender gender;
    private String phoneNumber;
    private String email;

}
