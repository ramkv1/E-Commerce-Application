package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ecommerce.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Order_Id;
	private Date order_date;
	private Double Total_Amount;
	private OrderStatus status;
	@JsonBackReference("customer-orders")
    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "cid",referencedColumnName = "customerId")
	private Customer customer;
    @JsonManagedReference("oders-orderItem")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderItemId")
    private List<OrderItem> orderItem;
}
