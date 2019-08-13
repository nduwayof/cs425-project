package com.ugandaairlines.ugair.booking.service;

import com.ugandaairlines.ugair.booking.model.Payment;

public interface IPaymentService {
	
	public abstract Payment savePayment(Payment booking);
	public abstract Iterable<Payment> findAllPayments();
	public abstract Payment findPaymentById(Integer paymentId);
	public abstract void deletePayment(Payment payment);

}
