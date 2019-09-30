package com.camp.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewFile {

	private int campFileNo;	
	private String savedFileName;
	private String userFileName;	
	private boolean flag;	
	private int campNo;
	private Date rentDate;
	
}
