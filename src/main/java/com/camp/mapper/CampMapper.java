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
	
	List<Camp> getCampKind(Criteria cri, String category);
	
	int getCampListCnt();

	int getCampKindCnt(String category);

//	void insertBoard(Board board);
//	
//	List<Board> selectBoard();
//	
//	void deleteBoard(int boardIdx);
//	
//	void updateBoard(Board board);
//	
//	///////////////////////////////
//	
//	void insertBoardFileList(List<BoardFile> list);
		
}
