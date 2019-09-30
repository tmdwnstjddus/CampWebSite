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
import com.camp.service.ProductService;
import com.camp.vo.Member;
import com.camp.vo.Product;
import com.camp.vo.ProductFile;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(path = "/productList", method = RequestMethod.GET)
	public String productListForm(Model model) {
		
		List<Product> products = productService.productList();
		
		for (Product product : products) {
			product.setFile(productService.findProductFile(product.getProductNo()));
		}
		
		model.addAttribute("products", products);
		
		return "product/productList";
		
	}
	
	@RequestMapping(path = "/productWrite", method = RequestMethod.GET)
	public String productWriteForm() {

		return "product/productWrite";
	}
	
	@RequestMapping(path = "/productWrite", method = RequestMethod.POST)
	public String productWrite(Product product, MultipartHttpServletRequest req, HttpSession session) {
		
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

					ProductFile productFile = new ProductFile();
					productFile.setSavedFileName(uniqueFileName);
					productFile.setUserFileName(userFileName);
					productFile.setFlag(true);
					product.setFile(productFile);
				}
			}

			List<MultipartFile> img = req.getFiles("imgFile");

			if (img != null) {
				File file = new File(path);
				ArrayList<ProductFile> files = new ArrayList<ProductFile>();

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

						ProductFile productFile = new ProductFile();
						productFile.setSavedFileName(uniqueFileName);
						productFile.setUserFileName(userFileName);
						productFile.setFlag(false);
						files.add(productFile);
						product.setFileList(files);
					}
				}
			}		
			
			Member loginuer = (Member)session.getAttribute("loginuser");
			product.setMemberId(loginuer.getMemberId());
			productService.writeProduct(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/product/productList";

	}
	
	@RequestMapping(path = "/productDetail/{productNo}", method = RequestMethod.GET)
	public String productDetail(@PathVariable int productNo, Model model) {
		
		Product products = productService.productByProductNo(productNo);
		List<ProductFile> productfiles = productService.prdocutFilesByProductNo(productNo);
		
		products.setFileList((ArrayList<ProductFile>) productfiles);
		
		model.addAttribute("product", products);
		
		return "product/productDetail";
		
		
	}
}
