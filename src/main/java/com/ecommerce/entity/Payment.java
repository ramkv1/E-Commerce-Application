package com.ecommerce.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.ecommerce.entity.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	private Double amount;
	private LocalDate paymentDate;
	private PaymentStatus status;
	@JsonBackReference("customer-payment")
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	private Customer customer;
}
