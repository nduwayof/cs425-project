package com.ugandaairlines.ugair.person.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Staff extends Person {
    private String position;
}
