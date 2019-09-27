package com.camp.service;

import java.util.List;
import java.util.Map;

import com.camp.vo.Camp;

import com.camp.vo.CampFile;
import com.camp.vo.Criteria;

public interface CampService {

	Camp findCampByCampNo(int campNo);

	List<CampFile> findCampFilesByCampNo(int campNo);
	
	List<Camp> findCampList(Criteria cri);
	List<Camp> findCampKind(Criteria cri, String category);
	
	int getListCnt();
	//	void writeBoard(Camp board);
//	
//	List<Camp> findBoard();
//
//	void deleteBoard(int boardIdx);
//
//	void updateBoard(Camp board);

	int getKindCnt(String category);

	
	
}
