package com.camp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.camp.common.Util;
import com.camp.service.CampService;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Member;



@Controller
@RequestMapping(path = "/camp/")
public class CampController {
	
	@Autowired
	CampService campService;
	
	
	@RequestMapping(path = "/campList", method = RequestMethod.GET)
	public String campingList(Model model, HttpSession session) {
		List<Camp> camps = campService.findCampList();
		
		for (Camp camp : camps) {
			camp.setFile(campService.findCampFile(camp.getCampNo()));
		}
		
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
		    
		    for (Camp camp : camps) {
				camp.setFile(campService.findCampFile(camp.getCampNo()));
			}

		    model.addAttribute("camps", camps);

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
	public String campWriteFrom() {

		return "camp/campWrite";
	}
	
	@RequestMapping(path = "/campWrite", method = RequestMethod.POST)
	public String campWrite(Camp camp, MultipartHttpServletRequest req, HttpSession session) {
		
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/resources/camp-files");// 최종 파일 저장 경로
		String userFileName = "";
		
		try {
			MultipartFile titleImg = req.getFile("titleImgFile");
			if (titleImg != null) {
				userFileName = titleImg.getOriginalFilename();
				if (userFileName.contains("\\")) { // iexplore 경우
					// C:\AAA\BBB\CCC.png -> CCC.png
					userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
				}
				if (userFileName != null && userFileName.length() > 0) { // 내용이 있는 경우
					if (userFileName.contains("\\")) { // iexplore 경우
						// C:\AAA\BBB\CCC.png -> CCC.png
						userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
					}
					String uniqueFileName = Util.makeUniqueFileName(path, userFileName);// 파일이름_1.jpg
					titleImg.transferTo(new File(path, uniqueFileName));// 파일 저장

					CampFile campFile = new CampFile();
					campFile.setSavedFileName(uniqueFileName);
					campFile.setUserFileName(userFileName);
					campFile.setFlag(true);
					camp.setFile(campFile);
				}
			}

			List<MultipartFile> img = req.getFiles("imgFile");

			if (img != null) {
				File file = new File(path);
				ArrayList<CampFile> files = new ArrayList<CampFile>();

				for (int i = 0; i < img.size(); i++) {
					userFileName = img.get(i).getOriginalFilename();
					if (userFileName.contains("\\")) { // iexplore 경우
						// C:\AAA\BBB\CCC.png -> CCC.png
						userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
					}
					if (userFileName != null && userFileName.length() > 0) { // 내용이 있는 경우

						System.out.println(userFileName + " 업로드");
						// 파일 업로드 소스 여기에 삽입
						String uniqueFileName = Util.makeUniqueFileName(path, userFileName);// 파일이름_1.jpg
						file = new File(path, uniqueFileName);
						img.get(i).transferTo(file);

						CampFile campFile = new CampFile();
						campFile.setSavedFileName(uniqueFileName);
						campFile.setUserFileName(userFileName);
						campFile.setFlag(false);
						files.add(campFile);
						camp.setFileList(files);
					}
				}
			}		
			
			Member loginuer = (Member)session.getAttribute("loginuser");
			camp.setMemberId(loginuer.getMemberId());
			campService.registerCamp(camp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/camp/campList";

	}
	
}
