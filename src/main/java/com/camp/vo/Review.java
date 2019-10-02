package com.camp.vo;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Review {	
	
	private int reviewNo;
	private String title;
	private String content;
	private String category;
	private Date regDate;
	private String memberId;
	private  int typeNo;
	
	private int campNo;
	private int productNo;
	
	private ReviewFile file;  // flag = 1
	private ArrayList<ReviewFile> fileList; // flag = 0
	
} 
