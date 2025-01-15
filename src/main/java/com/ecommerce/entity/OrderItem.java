package com.ecommerce.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	@Nonnull
	private Integer quantity;
//	@Nonnull
//	private Double pricePerProd;
	@Nonnull
	private Double subtotal;
	
	@JsonBackReference("Order-OrderItem")
	@ManyToOne(targetEntity = Orders.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "oid", referencedColumnName = "orderId")
	private Orders allorders;
	
	@JsonBackReference("Product-OrderItem")
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "orderItem")
	private List<Product> products;

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}

	
}
