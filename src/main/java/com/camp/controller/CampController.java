package com.camp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.camp.service.CampService;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;

import java.util.Map;



@Controller
@RequestMapping(path = "/camp/")
public class CampController {
	
	@Autowired
	CampService campService;
	
	
	@RequestMapping(path = "/campList", method = RequestMethod.GET)
	public String campingList(Model model) {
		List<Camp> camps = campService.findCampList();
		
		//조회 결과를 request 객체에 저장 (JSP에서 사용할 수 있도록)
		model.addAttribute("camps", camps);
		return "camp/campList";
	}
	
	@RequestMapping(path = "/campKind", method = RequestMethod.GET)
//	public ModelAndView campingKind(String category, ModelAndView mav) {
	public String campingKind(String category, Model model) {	
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		if (category == "all") {
//			List<Camp> camps = campService.findCampList();
//			model.addAttribute("camps", camps);
//			}
		
//			map.put("camps", camps);
//			mav.setViewName("camp/campList");
//			mav.addObject("map", map);
		
		
		    List<Camp> camps = campService.findCampKind(category);
//		    for (Camp camp: camps) {
//		         camp.setImg(campService.findUploadFileByUploadNo(camp.getCampNo()));
//		      }
		    model.addAttribute("camps", camps);
//		    map.put("camps", camps);
//			mav.setViewName("camp/campList");
//			mav.addObject("map", map);
	    
		
		
//		return mav;
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
