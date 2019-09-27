package com.camp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camp.service.ProductService;
import com.camp.vo.Product;
import com.camp.vo.ProductFile;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(path = "/productList", method = RequestMethod.GET)
	public String productList(Model model) {
		
		List<Product> products = productService.productList();
		
		model.addAttribute("products", products);
		
		return "product/productList";
		
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
