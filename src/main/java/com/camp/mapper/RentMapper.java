package com.camp.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Rental;

@Mapper
public interface RentMapper {

	List<Rental> selectRentsByCampNo(int campNo, Date rentDate);
	void insertRent(Rental rent);

}