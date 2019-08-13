package com.ugandaairlines.ugair.person.model;

import com.ugandaairlines.ugair.booking.model.Booking;

import javax.persistence.*;
import java.util.List;
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    @OneToMany(mappedBy = "passenger")
    List<Booking> bookings;
}
