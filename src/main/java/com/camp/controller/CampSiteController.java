package com.camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/upload")
public class CampSiteController {

	@RequestMapping(value = "/camping", method = RequestMethod.GET)
	public String campingList() {
		
		return "upload/camping";
	}
}
