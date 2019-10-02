package com.camp.vo;



import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Buy {
	
	private int buyNo;
	private String addr1; 
	private String addr2;
	private String addr3; 
	private Date buyDate;
	
	private int productNo;
	private String category;
	private String productName;
	private String price;
	private int sell;
	
	private ProductFile file;  // flag = 1
	private ArrayList<ProductFile> fileList; // flag = 0

	
}