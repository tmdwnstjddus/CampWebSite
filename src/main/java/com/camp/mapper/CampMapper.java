package com.camp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Camp;

import com.camp.vo.CampFile;
import com.camp.vo.Criteria;

@Mapper
public interface CampMapper {

	Camp selectCampByCampNo(int campNo);

	List<CampFile> selectCampFilesByCampNo(int campNo);
	
//	List<Map<String, Object>> getCampList(Criteria cri);
	List<Camp> getCampList(Criteria cri);
	
	List<Camp> getCampKind(Criteria cri);
	
	int getCampListCnt();

	int getCampKindCnt(String category);

	int insertCamp(Camp camp);

	void insertCampFile(CampFile titleFile);

	CampFile selectCampFile(int campNo);

//	void deleteBoard(int boardIdx);
//	
//	void updateBoard(Board board);
		
}
