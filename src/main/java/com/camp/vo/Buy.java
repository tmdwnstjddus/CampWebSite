package com.camp.vo;


import java.sql.Date;
import java.util.ArrayList;

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
	private String productName;
	private String price;
	
	private ProductFile file;  // flag = 1
	private ArrayList<ProductFile> fileList; // flag = 0

	
}