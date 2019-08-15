package com.ugandaairlines.ugair.booking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String paymentType;
    @OneToOne
    private Booking booking;
    private Double amount;

    public Payment(String paymentType, Booking booking, Double amount) {
        this.paymentType = paymentType;
        this.booking = booking;
        this.amount = amount;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
