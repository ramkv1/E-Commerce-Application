package com.ecommerce.entity;

import java.io.Serializable;

import com.ecommerce.entity.enums.DiscountType;
import com.ecommerce.entity.enums.ProductAvailability;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_Id;
	private String p_Model;
	private String p_Name;
	private Double p_price;
	private DiscountType discount;
	private String p_Brand;
	private String Description;
	private Integer StockQuantity;
	private ProductAvailability productAvailability;

}
