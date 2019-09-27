package com.camp.vo;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Product {
	
	private int productNo;
	private String name;
	private String content;
	private int price;
	private String category;
	private String memberId;
	
	private ArrayList<ProductFile> fileList;

}
