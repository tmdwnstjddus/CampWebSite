package com.camp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camp.service.CampService;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;

@Controller
@RequestMapping(value = "/camp")
public class CampSiteController {
	
	@Autowired
	CampService campService;

	@RequestMapping(value = "/campList", method = RequestMethod.GET)
	public String campingList() {
		
		return "camp/campList";
	}
	
	@RequestMapping(value = "/campDetail/{campNo}", method = RequestMethod.GET)
	public String detail(@PathVariable int campNo, Model model) {

		Camp camps = campService.findCampByCampNo(campNo);
		List<CampFile> campfiles = campService.findCampFilesByCampNo(campNo);

		camps.setFileList((ArrayList<CampFile>) campfiles);

		model.addAttribute("camp", camps);

		return "camp/campDetail";
	}
}
