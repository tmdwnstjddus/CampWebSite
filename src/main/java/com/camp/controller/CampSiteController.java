package com.camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/camp")
public class CampSiteController {

	@RequestMapping(value = "/campList", method = RequestMethod.GET)
	public String campingList() {
		
		return "camp/campList";
	}
}
