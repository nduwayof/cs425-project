package com.ugandaairlines.ugair.booking.model;

import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.person.model.Customer;
import com.ugandaairlines.ugair.person.model.Passenger;

import javax.persistence.*;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @OneToOne
    private Flight flight;
    private Double bookingCost;
    private EBookingStatus bookingStatus;

    @Transient
    private List<Passenger> passengers;

    public Booking() {
    }

    public Booking(Flight flight, Double bookingCost, EBookingStatus bookingStatus, List<Passenger> passengers, Customer customer) {
        this.flight = flight;
        this.bookingCost = bookingCost;
        this.bookingStatus = bookingStatus;
        this.passengers = passengers;
        this.customer = customer;
    }

    public EBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(EBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" , nullable = true)
    private Customer customer;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }



    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(Double bookingCost) {
        this.bookingCost = bookingCost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flight=" + flight +
                ", bookingCost=" + bookingCost +
                ", bookingStatus=" + bookingStatus +
                ", passengers=" + passengers +
                ", customer=" + customer +
                '}';
    }
}
