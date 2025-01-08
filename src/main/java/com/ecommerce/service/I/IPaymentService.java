package com.ecommerce.service.I;

import com.ecommerce.entity.Payment;

public interface IPaymentService {
	public Payment TxCommited(Payment payment);
}
