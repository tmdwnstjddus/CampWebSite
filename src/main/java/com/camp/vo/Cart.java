package com.camp.vo;


import lombok.Data;

@Data
public class Cart {
	
	private int cartNo;
	private int amount;
	private int productNo;
	private String memberId;
	
	
	private String name;
	private int money;
	private String productName;
	private String category;
	private String price;
	
}