package com.camp.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.camp.common.Util;
import com.camp.service.CampService;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;
import com.camp.vo.Member;
import com.camp.vo.PageMaker;
import com.camp.vo.Rent;


@Controller
@RequestMapping(path = "/camp/")
public class CampController {
	
	@Autowired
	CampService campService;
	
	
	@RequestMapping(path = "/campList", method = RequestMethod.GET)
	public String campingList(Criteria cri, String category, Model model) {
		
		if(category.equals("숙소")||category.equals("카라반")||category.equals("글램핑")) {
			int kindCnt = campService.getKindCnt(category);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(kindCnt);
			cri.setCategory(category);
			List<Camp> camps = campService.findCampKind(cri);
			for (Camp camp : camps) {
				camp.setFile(campService.findCampFile(camp.getCampNo()));
			}
			model.addAttribute("category", category);
			model.addAttribute("camps", camps);
			model.addAttribute("pageMaker", pageMaker);
		}
		else {
			//조회 결과를 request 객체에 저장 (JSP에서 사용할 수 있도록)
			int listCnt = campService.getListCnt();
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(listCnt);
			List<Camp> camps = campService.findCampList(cri);
			
			for (Camp camp : camps) {
				camp.setFile(campService.findCampFile(camp.getCampNo()));
			}
			model.addAttribute("category", "all");
			model.addAttribute("camps", camps);
			model.addAttribute("pageMaker", pageMaker);
	
		}
		
	    return "camp/campList";
	}
	
	@RequestMapping(path = "/campDetail/{campNo}", method = RequestMethod.GET)
	public String campDetail(@PathVariable int campNo, Model model) {

		Camp camps = campService.findCampByCampNo(campNo);
		List<CampFile> campfiles = campService.findCampFilesByCampNo(campNo);
		
		int nowYear = 0, nowMonth = 0, nowDay = 0;
		Date date = new Date();
		SimpleDateFormat yearSdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSdf = new SimpleDateFormat("MM");
		SimpleDateFormat daySdf = new SimpleDateFormat("dd");
		nowYear = Integer.parseInt(yearSdf.format(date));
		nowMonth = Integer.parseInt(monthSdf.format(date));
		nowDay = Integer.parseInt(daySdf.format(date));
		
		/* 현재 날짜	*/
		model.addAttribute("nowYear", nowYear);
		model.addAttribute("nowMonth", nowMonth);
		model.addAttribute("nowDay", nowDay);

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
	
	@RequestMapping(path = "/campUpdate/{campNo}", method = RequestMethod.GET)
	public String campUpdateFrom(@PathVariable int campNo, Model model) {
		
		Camp camp = campService.findCampByCampNo(campNo);
		CampFile titlefile = campService.findCampFile(campNo);
		List<CampFile> campfiles = campService.findCampFilesByCampNo(campNo);
		
		camp.setFile(titlefile);
		camp.setFileList((ArrayList<CampFile>) campfiles);
		
		model.addAttribute("camp", camp);

		return "camp/campUpdate";
	}
	
	@RequestMapping(path = "/campUpdate", method = RequestMethod.POST)
	public String campUpdate(Camp camp, MultipartHttpServletRequest req, HttpSession session, Model model) {
		
		camp.setFile(campService.findCampFile(camp.getCampNo()));
		
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
					campFile.setCampNo(camp.getCampNo());
					
					campService.updateCampFile(campFile);
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
						campFile.setCampNo(camp.getCampNo());
						files.add(campFile);
						
						camp.setFileList(files);
						campService.insertCampFiles(camp, camp.getCampNo());
					}
				}
			}		
			campService.updateCamp(camp);
			model.addAttribute("camp", camp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/camp/campDetail/"+ camp.getCampNo();

	}
	

	@RequestMapping(path = "/campDelete/{campNo}", method = RequestMethod.GET)
	public String delete(@PathVariable int campNo) {

		campService.deleteCamp(campNo);

		return "redirect:/camp/campList";
	}
	
	
	@RequestMapping(path = "/delete-file", method = RequestMethod.GET)
	@ResponseBody
	public String deletefile(int campFileNo, Model model) {
		//데이터베이스에서 파일 정보 조회
		CampFile file = campService.findCampFileByCampFileNo(campFileNo);
		
		//데이터베이스에서 파일 데이터 삭제
		campService.deleteCampFile(campFileNo);

		return "success" ; 
	}
	
	@RequestMapping(value = "/calendar", method = RequestMethod.POST)
	public String calendar(int campNo, Model model, 
			@RequestParam(defaultValue = "0") int year, 
			@RequestParam(defaultValue = "0") int month, 
			@RequestParam(defaultValue = "0") int day) {

		

//		if (year == 0) {
//			year = Integer.parseInt(yearSdf.format(date));
//		}
//		if (month == 0) {
//			month = Integer.parseInt(monthSdf.format(date));
//		}
//		if (day == 0) {
//			day = Integer.parseInt(daySdf.format(date));
//		}
		
		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		int[] lastDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {//2월 lastDay
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
		for (int i = 0; i < month - 1; i++) {
			total += lastDay[i];
		}
		total++;
		int week = total % 7;

		/* 캘린더 change	*/
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		
		
		model.addAttribute("strWeek", strWeek);
		model.addAttribute("lastDay", lastDay[month - 1]);
		model.addAttribute("week", week);

		/*--------------------------------------------------*/

		Camp camp = campService.findCampByCampNo(campNo);
		if (camp == null) {
			return "redirect:/camp/campList";
		}
		
		camp.setFile(campService.findCampFile(camp.getCampNo()));
		camp.setFileList((ArrayList<CampFile>) campService.findCampFilesByCampNo(camp.getCampNo()));

		model.addAttribute("camp", camp);

		return "camp/calendar";
	}
	
	@RequestMapping(value = "/time", method = RequestMethod.POST)
	public String time(int campNo, Model model, String year, String month, String day, HttpSession session) {

		Member loginuser = (Member) session.getAttribute("loginuser");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringTokenizer st = new StringTokenizer(sdf.format(date), "-");

		if (year == null) {
			year = st.nextToken();
		}
		if (month == null) {
			month = st.nextToken();
		}
		if (day == null) {
			day = st.nextToken();
		}

		/*--------------------------------------------------*/

		Camp camp = campService.findCampByCampNo(campNo);
		if (camp == null) {
			return "redirect:/camp/campList";		
		}

		try {
			java.util.Date utildate = sdf.parse(year + "-" + month + "-" + day);
			java.sql.Date rentDate = new java.sql.Date(utildate.getTime());
			ArrayList<Rent> rents = campService.findRentsByCampNo(campNo, rentDate);

			model.addAttribute("rents", rents);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("camp", camp);
		model.addAttribute("loginuser", loginuser);

		return "camp/time";
	}
	
	@RequestMapping(path = "/campRent", method = RequestMethod.GET)
	public String rentForm(int campNo, Model model, HttpSession session) {

		Member loginuser = (Member) session.getAttribute("loginuser");
		int nowYear = 0, nowMonth = 0, nowDay = 0;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringTokenizer st = new StringTokenizer(sdf.format(date), "-");

		nowYear = Integer.parseInt(st.nextToken());
		nowMonth = Integer.parseInt(st.nextToken());
		nowDay = Integer.parseInt(st.nextToken());

		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		int[] lastDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int total = (nowYear - 1) * 365 + (nowYear - 1) / 4 - (nowYear - 1) / 100 + (nowYear - 1) / 400;
		if ((nowYear % 4 == 0 && nowYear % 100 != 0) || (nowYear % 400 == 0)) {// 2월 lastDay
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
		for (int i = 0; i < nowMonth - 1; i++) {
			total += lastDay[i];
		}
		total++;
		int week = total % 7;

		/* 현재 날짜 */
		model.addAttribute("nowYear", nowYear);
		model.addAttribute("nowMonth", nowMonth);
		model.addAttribute("nowDay", nowDay);

		model.addAttribute("strWeek", strWeek);
		model.addAttribute("lastDay", lastDay[nowMonth - 1]);
		model.addAttribute("week", week);

		/*--------------------------------------------------*/

		Camp camp = campService.findCampByCampNo(campNo);
		if (camp == null) { 
			return "redirect:/camp/campList";
		}

		camp.setFile(campService.findCampFile(camp.getCampNo()));
		camp.setFileList((ArrayList<CampFile>) campService.findCampFilesByCampNo(camp.getCampNo()));

//		camp.setReviews((ArrayList<Review>) campService.findReviewListByCampNo(camp.getCampNo()));
		
		try {
			String rentDateStr = Integer.toString(nowYear) + "-" 
								+ Integer.toString(nowMonth) + "-"
								+ Integer.toString(nowDay);
			java.util.Date utildate = sdf.parse(rentDateStr);
			java.sql.Date rentDate = new java.sql.Date(utildate.getTime());
			ArrayList<Rent> rents = campService.findRentsByCampNo(campNo, rentDate);
			
			model.addAttribute("rents", rents);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("camp", camp);
		model.addAttribute("loginuser", loginuser);

		return "camp/campRent";
	}
	

//	@RequestMapping(value = "/campRent", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
//	@ResponseBody
//	public String rent(Model model, Rent rent, int year, int month, int day, int startTime, int endTime, HttpSession session) {
//		
//		Member loginuser = (Member) session.getAttribute("loginuser");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//
//		rent.setMemberId(loginuser.getMemberId());
//		String strDate = year+"-"+month+"-"+day;
//		Date date = null;
//		try {
//			date = sdf.parse(strDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		rent.setRentDate(date);
//		rentService.registerRent(rent);
//
//		return "success";
//	}
	
}
