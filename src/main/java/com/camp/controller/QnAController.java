package com.camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/upload")
public class QnAController {

	@RequestMapping(path = "/qna", method = RequestMethod.GET)
	public String qnaList() {
		
		return "upload/qna";
	}
}
