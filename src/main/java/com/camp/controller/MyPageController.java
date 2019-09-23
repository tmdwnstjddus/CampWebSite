package com.camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/upload")
public class MyPageController {

	@RequestMapping(path = "/mypage", method = RequestMethod.GET)
	public String mypageList() {
		
		return "upload/mypage";
	}
}
