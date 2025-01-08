package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Payment;
import com.ecommerce.repo.PaymentRepository;
import com.ecommerce.service.I.IPaymentService;


@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment TxCommited(Payment payment) {
		return paymentRepository.save(payment);
	}

}
