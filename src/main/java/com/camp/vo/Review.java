package com.camp.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Review {	
	
	private int reviewno;
	private String title;
	private String content;
	private String category;
	
	private String memberId;
	
	private CampFile file;  // flag = 1
	private ArrayList<CampFile> fileList; // flag = 0
	
} 
