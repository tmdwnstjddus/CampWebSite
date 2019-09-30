package com.camp.vo;


import java.sql.Date;

import lombok.Data;

@Data
public class Rent {
	
	private Date rentDate;
	private int campNo;	
	private String memberId;
	private int startDate;
	private int endDate;
}