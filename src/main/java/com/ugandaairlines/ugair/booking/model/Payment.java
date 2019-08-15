package com.ugandaairlines.ugair.booking.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String paymentType;
    @OneToOne
    private Booking booking;
    private Double amount;

}
