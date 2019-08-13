package com.ugandaairlines.ugair.person.model;

import com.ugandaairlines.ugair.booking.model.Booking;

import javax.persistence.*;
import java.util.List;
@Entity
public class Passenger extends Person {

    @OneToMany(mappedBy = "passenger")
    List<Booking> bookings;
}
