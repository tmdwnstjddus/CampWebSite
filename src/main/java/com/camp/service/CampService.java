package com.camp.service;

import java.util.List;

import com.camp.vo.Camp;

import com.camp.vo.CampFile;

public interface CampService {

	Camp findCampByCampNo(int campNo);

	List<CampFile> findCampFilesByCampNo(int campNo);
	
	List<Camp> findCampList();

	List<Camp> findCampKind(String category);

//	void writeBoard(Camp board);
//	
//	List<Camp> findBoard();
//
//	void deleteBoard(int boardIdx);
//
//	void updateBoard(Camp board);
	
}
