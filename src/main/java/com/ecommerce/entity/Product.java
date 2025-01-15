package com.ecommerce.entity;

import java.io.Serializable;

import com.ecommerce.entity.enums.DiscountType;
import com.ecommerce.entity.enums.ProductAvailability;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_Id;
	@NonNull
	private String p_Model;
	@NonNull
	private String p_Name;
	@NonNull
	private Double p_MRP;
	@NonNull
	private DiscountType discount;
	@NonNull
	private String Description;
	@NonNull
	private Integer StockQuantity;
	@NonNull
	private ProductAvailability productAvailability;
	
	@JsonBackReference("Product-OrderItem") // Marks this as the back part of the reference
	@ManyToOne(targetEntity = OrderItem.class,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "pid",referencedColumnName = "orderItemId")
	private OrderItem orderItem;

	@Override
	public String toString() {
		return "Product [p_Id=" + p_Id + ", p_Model=" + p_Model + ", p_Name=" + p_Name + ", p_MRP=" + p_MRP
				+ ", discount=" + discount + ", Description=" + Description + ", StockQuantity=" + StockQuantity
				+ ", productAvailability=" + productAvailability + "]";
	}
	
	


}
