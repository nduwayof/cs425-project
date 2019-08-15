package com.ugandaairlines.ugair.person.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	@NotBlank(messange = "First Name Erquired")
    private String firstName;
	
    private String middleName;
	@NotBlank(messange = "Last Name Erquired")
    private String lastName;
    private EGender gender;
    private String phoneNumber;
	@NotBlank(messange = "Email Erquired")
    private String email;

}
