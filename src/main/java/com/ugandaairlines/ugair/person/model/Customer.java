package com.ugandaairlines.ugair.person.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	@NotBlank(message = "First Name Erquired")
    private String firstName;
	
    private String middleName;
	@NotBlank(message = "Last Name Erquired")
    private String lastName;
    private EGender gender;
    private String phoneNumber;
	@NotBlank(message = "Email Erquired")
    private String email;

}
