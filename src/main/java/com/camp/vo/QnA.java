package com.camp.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class QnA {
	
	private int qaNo;
	private String title;
	private String content;
	private Date regDate;
	private String memberId;
	

}
