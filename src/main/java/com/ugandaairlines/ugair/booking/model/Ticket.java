package com.ugandaairlines.ugair.booking.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.person.model.Passenger;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketNo;
    @OneToOne
    private Flight flight;
    @OneToOne
    private Booking booking;
}
