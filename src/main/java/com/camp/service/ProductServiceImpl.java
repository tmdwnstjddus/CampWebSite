package com.camp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.ProductMapper;
import com.camp.vo.Product;
import com.camp.vo.ProductFile;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	

	@Override
	public List<Product> productList() {
		
		List<Product> products = productMapper.getProductList();
		
		return products;
		
	}

	@Override
	public Product productByProductNo(int productNo) {
		
		Product products = productMapper.selectProductByProductNo(productNo);
		
		return products;
		
	}


	@Override
	public List<ProductFile> prdocutFilesByProductNo(int productNo) {
		
		List<ProductFile> productFile = productMapper.selectProductFilesByProductNo(productNo);
		
		return productFile;
		
	}
	
//	@Override
//	public List<CampFile> findCampFilesByCampNo(int campNo) {
//		
//		List<CampFile> campFile = campMapper.selectCampFilesByCampNo(campNo);
//		return campFile;
//		
//	}
//
//	@Override
//	public Camp findCampByCampNo(int campNo) {
//		
//		Camp camp = campMapper.selectCampByCampNo(campNo);
//		return camp;
//		
//	}
//
//
//	@Override
//	public List<Camp> findCampKind(String category) {
//		
//		List<Camp> camps = campMapper.getCampKind(category);
//		return camps;
//		
//	}

	


}

