package com.camp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Product;
import com.camp.vo.ProductFile;

@Mapper
public interface ProductMapper {
	
	List<Product> getProductList();

	Product selectProductByProductNo(int productNo);

	List<ProductFile> selectProductFilesByProductNo(int productNo);

//	List<CampFile> selectCampFilesByCampNo(int campNo);
//	
//	Camp selectCampByCampNo(int campNo);
//	
//	List<Camp> getCampKind(String category);

		
}
