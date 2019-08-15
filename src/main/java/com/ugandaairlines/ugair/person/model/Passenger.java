package com.ugandaairlines.ugair.person.model;

import com.ugandaairlines.ugair.booking.model.Booking;
import com.ugandaairlines.ugair.flight.model.Flight;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;



@Entity

public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;
	@NotBlank(messange = "First Name required")
    private String firstName;
    private String middleName;
	@NotBlank(messange = "Last First Name required")
    private String lastName;
	@NotNull
    private EGender gender;
    private String phoneNumber;
    private String email;
    private String passengerClass;
	
	@NotBlank(messange = "Destination Address recquired")
    private String destinationAddress;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;


    @ManyToOne
    private Booking booking;

    public Passenger() {
    }

    public Passenger(String firstName, String middleName, String lastName, EGender gender, String phoneNumber, String email, String passengerClass, String destinationAddress, Flight flight, Booking booking) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passengerClass = passengerClass;
        this.destinationAddress = destinationAddress;
        this.flight = flight;
        this.booking = booking;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(String passengerClass) {
        this.passengerClass = passengerClass;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passengerClass='" + passengerClass + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }
}
