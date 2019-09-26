package com.camp.service;

import java.util.List;

import com.camp.vo.Camp;

public interface CampService {

	List<Camp> findCampList();

	List<Camp> findCampKind(String category);
	
	
}
