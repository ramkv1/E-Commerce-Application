package com.ecommerce.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String customerEmailId;
	@NonNull
	@Pattern(regexp = "^\\+?[0-9]*$", message = "Invalid phone number format")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
	private String phoneNumber;
	@JsonManagedReference("customer-address")
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Address> addresses;
	@JsonManagedReference("customer-order")
	@OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "customer")
	private List<Orders> orders;
}
