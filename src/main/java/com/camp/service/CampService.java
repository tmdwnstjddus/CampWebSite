package com.camp.service;

import java.util.List;

import com.camp.vo.Camp;

import com.camp.vo.CampFile;

public interface CampService {

	Camp findCampByCampNo(int campNo);

	List<CampFile> findCampFilesByCampNo(int campNo);
	
	List<Camp> findCampList();

	List<Camp> findCampKind(String category);

	Integer registerCamp(Camp camp);

	void insertCampFiles(Camp camp, int campNo);

	CampFile findCampFile(int campNo);

//	void deleteBoard(int boardIdx);
//
//	void updateBoard(Camp board);
	
}
