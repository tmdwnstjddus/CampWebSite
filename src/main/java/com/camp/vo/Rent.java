package com.camp.vo;


import java.sql.Date;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Rent {
	
	private Date rentDate;
	private int campNo;	
	private String memberId; 
	private int startDate;
	private int endDate;

	private String category;
	private String campName;
	private int price;

	private CampFile file;  // flag = 1
	private ArrayList<CampFile> fileList; // flag = 0
}