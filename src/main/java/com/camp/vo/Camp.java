package com.camp.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Camp {	
	
	private int campNo;
	private String campName;
	private String content;
	private int price;
	private String category;
	private String memberId;
	
	private ArrayList<CampFile> fileList;

}
