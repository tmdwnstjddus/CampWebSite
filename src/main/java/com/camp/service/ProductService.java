package com.camp.service;

import java.util.List;

import com.camp.vo.Product;
import com.camp.vo.ProductFile;

public interface ProductService {

	List<Product> productList();

	Product productByProductNo(int productNo);

	List<ProductFile> prdocutFilesByProductNo(int productNo);

	int writeProduct(Product product);

	ProductFile findProductFile(int productNo);
	
	//void insertProductFiles(Product product, int productNo);

	//List<CampFile> findCampFilesByCampNo(int campNo);
	
	//Camp findCampByCampNo(int campNo);

	//List<Camp> findCampKind(String category);

}
