package com.ugandaairlines.ugair.flight.model;

import com.ugandaairlines.ugair.airport.model.Aircraft;
import com.ugandaairlines.ugair.airport.model.Airport;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;
	
    private LocalDateTime arrivalTime;

	@NotNull(message = "Departure Airport Required")
    @OneToOne
    private Airport departureAirport;
	
	@NotNull(message = "Arrival Airport Required")
    @OneToOne
    private Airport arrivalAirport;
	
	@NotNull
    @OneToOne
    private Aircraft aircraft;

    @OneToMany(mappedBy = "flight")
    private List<FlightCost> flightCosts;
	
	@NotNull
    private Double economyCost;

    private Double businessCost;

    public Double getEconomyCost() {
        return economyCost;
    }

    public void setEconomyCost(Double economyCost) {
        this.economyCost = economyCost;
    }

    public Double getBusinessCost() {
        return businessCost;
    }

    public void setBusinessCost(Double businessCost) {
        this.businessCost = businessCost;
    }

    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @Transient
    private String departureHour;

    @Transient
    private String arrivalHour;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +

                ", flightCosts=" + flightCosts +
                ", economyCost=" + economyCost +
                ", businessCost=" + businessCost +
                ", departureHour='" + departureHour + '\'' +
                ", arrivalHour='" + arrivalHour + '\'' +
                '}';
    }
}
