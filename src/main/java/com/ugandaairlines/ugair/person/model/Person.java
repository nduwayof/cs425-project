package com.ugandaairlines.ugair.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private EGender gender;
    private String phoneNumber;
    private String email;
    //private Address address// to decide if we are having a entity or keeping it as string


}
