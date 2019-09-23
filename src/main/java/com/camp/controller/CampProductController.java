package com.camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/upload")
public class CampProductController {
	
	@RequestMapping(path = "/product", method = RequestMethod.GET)
	public String productList() {
		
		return "upload/product";
	}

}
