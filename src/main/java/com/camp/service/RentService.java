package com.camp.service;

import java.sql.Date;
import java.util.ArrayList;

import com.camp.vo.Rental;

public interface RentService {
	
	ArrayList<Rental> findRentsByCampNo(int campNo, Date rentDate);
	void registerRent(Rental rent);

}
