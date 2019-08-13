package com.ugandaairlines.ugair.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugandaairlines.ugair.booking.model.Payment;
import com.ugandaairlines.ugair.booking.repository.IPaymentRepository;
import com.ugandaairlines.ugair.booking.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment booking) {
	
		return paymentRepository.save(booking);
	}

	@Override
	public Iterable<Payment> findAllPayments() {
	
		return paymentRepository.findAll();
	}

	@Override
	public Payment findPaymentById(Integer paymentId) {

		return paymentRepository.findById(paymentId).orElse(null);
	}

	@Override
	public void deletePayment(Payment payment) {
		paymentRepository.delete(payment);
		
	}

}
