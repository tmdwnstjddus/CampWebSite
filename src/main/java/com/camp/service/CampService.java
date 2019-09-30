package com.camp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;
import com.camp.vo.Rent;

public interface CampService {

	Camp findCampByCampNo(int campNo);
	List<CampFile> findCampFilesByCampNo(int campNo);
	CampFile findCampFile(int campNo);	
	CampFile findCampFileByCampFileNo(int campFileNo);

	List<Camp> findCampList(Criteria cri);	
	List<Camp> findCampKind(Criteria cri, String category);
	
	int getListCnt();
	int getKindCnt(String category);

	Integer registerCamp(Camp camp);
	void insertCampFiles(Camp camp, int campNo);		

	void updateCamp(Camp camp);	
	void updateCampFile(CampFile campFile);

	void deleteCamp(int campNo);
	void deleteCampFile(int campFileNo);
	
	ArrayList<Rent> findRentsByCampNo(int campNo, Date rentDate);

}
