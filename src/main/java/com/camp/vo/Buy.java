package com.camp.vo;


import java.sql.Date;

import lombok.Data;

@Data
public class Buy {
	
	private int butNo;
	private String addr1;
	private String addr2;
	private String addr3;
	private Date buyDate;
	
	private int productNo;
	private String category;
	private String name;
	private String price;
	
}