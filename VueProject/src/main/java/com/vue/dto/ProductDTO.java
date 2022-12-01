package com.vue.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	private int productId;
	private String productName;
	private int productPrice;
	private String productState;
	private Date productRegDate;
}
