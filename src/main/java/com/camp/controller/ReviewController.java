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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.camp.common.Util;
import com.camp.service.ReviewService;
import com.camp.vo.Member;

import com.camp.vo.Review;
import com.camp.vo.ReviewFile;

@Controller
@RequestMapping(path = "/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(path = "/reviewWrite", method = RequestMethod.GET)
	public String reviewWriteFrom() {

		return "review/reviewWrite";
	}
	
	@RequestMapping(path = "/reviewWrite", method = RequestMethod.POST)
	public String reviewUpload(Review review, MultipartHttpServletRequest req, HttpSession session) {
		
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/resources/review-files");// 최종 파일 저장 경로
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

					ReviewFile reviewFile = new ReviewFile();
					reviewFile.setSavedFileName(uniqueFileName);
					reviewFile.setUserFileName(userFileName);
					reviewFile.setFlag(true);
					review.setFile(reviewFile);
				}
			}
		
			Member loginuer = (Member)session.getAttribute("loginuser");
			review.setMemberId(loginuer.getMemberId());
			reviewService.writeReview(review);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/orderlist?memberId="+review.getMemberId();
	}
	
	@RequestMapping(path = "/reviewUpdate/{reviewNo}", method = RequestMethod.GET)
	public String reviewUpdateFrom(@PathVariable int reviewNo, Model model) {
		
		Review review = reviewService.findReviewByReviewNo(reviewNo);
		ReviewFile titlefile = reviewService.findReviewFile(reviewNo);

		review.setFile(titlefile);
		
		model.addAttribute("reivew", review);

		return "review/reivewUpdate";
	}
	
	@RequestMapping(path = "/reviewUpdate", method = RequestMethod.POST)
	public String campUpdate(Review review, MultipartHttpServletRequest req, HttpSession session, Model model) {
		
		review.setFile(reviewService.findReviewFile(review.getReviewNo()));
		
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/resources/review-files");// 최종 파일 저장 경로
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

					ReviewFile reviewFile = new ReviewFile();
					reviewFile.setSavedFileName(uniqueFileName);
					reviewFile.setUserFileName(userFileName);
					reviewFile.setFlag(true);
					reviewFile.setReviewNo(review.getReviewNo());
					
					reviewService.updateReviewFile(reviewFile);
					review.setFile(reviewFile);
				}
			

			
			}		
			reviewService.updateReivew(review);
			model.addAttribute("review", review);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  "redirect:/member/orderlist?memberId="+review.getMemberId();

	}
	
	@RequestMapping(path = "/reviewDelete/{reviewNo}", method = RequestMethod.GET)
	public String delete(@PathVariable int reviewNo, String memberId) {

		reviewService.deleteReview(reviewNo);

		return "redirect:/member/orderlist?memberId="+memberId;
	}
	
	
	@RequestMapping(path = "/delete-reviewfile", method = RequestMethod.GET)
	@ResponseBody
	public String deletefile(int reviewFileNo, Model model) {
		//데이터베이스에서 파일 정보 조회
		ReviewFile review = reviewService.findReviewFileByReviewFileNo(reviewFileNo);
		
		//데이터베이스에서 파일 데이터 삭제
		reviewService.deleteReviewFile(reviewFileNo);

		return "success" ; 
	}
	
}
