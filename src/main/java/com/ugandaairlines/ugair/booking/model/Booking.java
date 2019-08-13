package com.ugandaairlines.ugair.booking.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.model.FlightCost;
import com.ugandaairlines.ugair.person.model.Passenger;
import lombok.Data;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    @OneToOne
    private Flight flight;
    @OneToOne
    private FlightCost flightCost;

    @OneToOne
    private Passenger passenger;

}
