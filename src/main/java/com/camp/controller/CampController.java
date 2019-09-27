package com.camp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.camp.service.CampService;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;
import com.camp.vo.PageMaker;



@Controller
@RequestMapping(path = "/camp/")
public class CampController {
	
	@Autowired
	CampService campService;
	
	
	@RequestMapping(path = "/campList", method = RequestMethod.GET)
	public String campingList(Criteria cri, Model model) {
		
		int listCnt = campService.getListCnt();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(listCnt);
		
		List<Camp> camps = campService.findCampList(cri);

		model.addAttribute("camps", camps);
		model.addAttribute("pageMaker", pageMaker);
	    return "camp/campList";
	}
	
	@RequestMapping(path = "/campKind", method = RequestMethod.GET)

	public String campingKind(Criteria cri, String category, Model model) {	

		
		int kindCnt = campService.getKindCnt(category);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(kindCnt);
		
		
	    List<Camp> camps = campService.findCampKind(cri, category);

	    model.addAttribute("camps", camps);
	    model.addAttribute("pageMaker", pageMaker);
	    
		return "camp/campList";
	}
	
	@RequestMapping(value = "/campDetail/{campNo}", method = RequestMethod.GET)
	public String campDetail(@PathVariable int campNo, Model model) {

		Camp camps = campService.findCampByCampNo(campNo);
		List<CampFile> campfiles = campService.findCampFilesByCampNo(campNo);

		camps.setFileList((ArrayList<CampFile>) campfiles);

		model.addAttribute("camp", camps);

		return "camp/campDetail";
	}
	
	@RequestMapping(path = "/campWrite", method = RequestMethod.GET)
	public String campWrite() {

		return "camp/campWrite";
	}
	
}
