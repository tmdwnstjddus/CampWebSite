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
	
	List<Camp> findCampKind(Criteria cri);

	Integer registerCamp(Camp camp);

	void insertCampFiles(Camp camp, int campNo);

	CampFile findCampFile(int campNo);
	
	int getListCnt();
	
//	void deleteBoard(int boardIdx);
//
//	void updateBoard(Camp board);

	int getKindCnt(String category);
	
}
