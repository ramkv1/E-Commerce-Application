package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ecommerce.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@RequiredArgsConstructor
public class Orders implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Nonnull
	private Date order_date;
	@Nonnull
	private Double Total_Amount;
	@Nonnull
	private OrderStatus status;
	@JsonManagedReference("Order-OrderItem")
	@OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "allorders")
	private List<OrderItem> orderItems;
	@Override
	public String toString() {
		return "Orders [order_Id=" + orderId + ", order_date=" + order_date + ", Total_Amount=" + Total_Amount
				+ ", status=" + status + ", orderItems=" + orderItems + "]";
	}

}
