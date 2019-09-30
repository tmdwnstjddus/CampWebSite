//package com.camp.controller;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.camp.common.Util;
//import com.camp.vo.Member;
//import com.camp.vo.ProductFile;
//
//@Controller
//@RequestMapping(path = "/review")
//public class ReviewController {
//	
//	@Autowired
//	ReviewService reviewService;
//	
//	@RequestMapping(path = "/productWrite", method = RequestMethod.GET)
//	public String productWriteForm() {
//
//		return "product/productWrite";
//	}
//	
//	@RequestMapping(path = "/reviewWrite", method = RequestMethod.POST)
//	public String reviewWrite(Review review, MultipartHttpServletRequest req, HttpSession session) {
//		
//		ServletContext application = req.getServletContext();
//		String path = application.getRealPath("/resources/camp-files");// 최종 파일 저장 경로
//		String userFileName = "";
//		
//		try {
//			MultipartFile titleImg = req.getFile("titleImgFile");
//			if (titleImg != null) {
//				userFileName = titleImg.getOriginalFilename();
//				if (userFileName.contains("\\")) { // iexplore 경우
//					// C:\AAA\BBB\CCC.png -> CCC.png
//					userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
//				}
//				if (userFileName != null && userFileName.length() > 0) { // 내용이 있는 경우
//					if (userFileName.contains("\\")) { // iexplore 경우
//						// C:\AAA\BBB\CCC.png -> CCC.png
//						userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
//					}
//					String uniqueFileName = Util.makeUniqueFileName(path, userFileName);// 파일이름_1.jpg
//					titleImg.transferTo(new File(path, uniqueFileName));// 파일 저장
//
//					ReviewFile reviewFile = new ReviewFile();
//					reviewFile.setSavedFileName(uniqueFileName);
//					reviewFile.setUserFileName(userFileName);
//					reviewFile.setFlag(true);
//					review.setFile(reviewFile);
//				}
//			}
//
//			List<MultipartFile> img = req.getFiles("imgFile");
//
//			if (img != null) {
//				File file = new File(path);
//				ArrayList<ProductFile> files = new ArrayList<ProductFile>();
//
//				for (int i = 0; i < img.size(); i++) {
//					userFileName = img.get(i).getOriginalFilename();
//					if (userFileName.contains("\\")) { // iexplore 경우
//						// C:\AAA\BBB\CCC.png -> CCC.png
//						userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
//					}
//					if (userFileName != null && userFileName.length() > 0) { // 내용이 있는 경우
//
//						System.out.println(userFileName + " 업로드");
//						// 파일 업로드 소스 여기에 삽입
//						String uniqueFileName = Util.makeUniqueFileName(path, userFileName);// 파일이름_1.jpg
//						file = new File(path, uniqueFileName);
//						img.get(i).transferTo(file);
//
//						ReviewFile reviewFile = new ReviewFile();
//						reviewFile.setSavedFileName(uniqueFileName);
//						reviewFile.setUserFileName(userFileName);
//						reviewFile.setFlag(false);
//						files.add(reviewFile);
//						review.setFileList(files);
//					}
//				}
//			}		
//			
//			Member loginuer = (Member)session.getAttribute("loginuser");
//			review.setMemberId(loginuer.getMemberId());
//			reviewService.writeProduct(product);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/product/productList";
//
//	}
//}
