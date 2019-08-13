package com.ugandaairlines.ugair.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugandaairlines.ugair.booking.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
