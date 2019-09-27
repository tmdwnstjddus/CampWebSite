package com.camp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Camp;

import com.camp.vo.CampFile;

@Mapper
public interface CampMapper {

	Camp selectCampByCampNo(int campNo);

	List<CampFile> selectCampFilesByCampNo(int campNo);
	
	List<Camp> getCampList();
	
	List<Camp> getCampKind(String category);

	int insertCamp(Camp camp);

	void insertCampFile(CampFile titleFile);

	CampFile selectCampFile(int campNo);

//	void deleteBoard(int boardIdx);
//	
//	void updateBoard(Board board);
		
}
