package com.camp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.CampMapper;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;

@Service
public class CampServiceImpl implements CampService {
	
	@Autowired
	private CampMapper campMapper;

	@Override
	public Camp findCampByCampNo(int campNo) {
		Camp camp = campMapper.selectCampByCampNo(campNo);
		return camp;
	}

	@Override
	public List<CampFile> findCampFilesByCampNo(int campNo) {
		List<CampFile> campFile = campMapper.selectCampFilesByCampNo(campNo);
		return campFile;
	}
	

//	@Override
//	public List<Map<String, Object>> findCampList(Criteria cri) {
//		
//		return (List<Map<String, Object>>)campMapper.getCampList(cri); 
//		
//	}
	
	@Override
	public List<Camp> findCampList(Criteria cri) {
		List<Camp> camps = campMapper.getCampList(cri);
		return camps;
		
	}

	@Override
	public List<Camp> findCampKind(Criteria cri, String category) {
		
		List<Camp> camps = campMapper.getCampKind(cri, category);
		return camps;
	}

	@Override
	public int getListCnt() {
		int Cnt = campMapper.getCampListCnt();
		return Cnt;
	}

	
	@Override
	public int getKindCnt(String category) {
		int Cnt = campMapper.getCampKindCnt(category);
		return Cnt;
	}

	
	
//	@Override
//	public void writeBoard(Camp board) {
//		
//		boardMapper.insertBoard(board);
//		for (CampFile file : board.getFileList()) {
//			file.setBoardIdx(board.getBoardIdx());
//			//boardMapper.insertBoardFileList(list); //count 만큼 반복
//		}
//		boardMapper.insertBoardFileList(board.getFileList()); //1회
//		
//	}
//
//	@Override
//	public List<Camp> findBoard() {
//		List<Camp> boards = boardMapper.selectBoard();
//		return boards;
//	}
//
//	@Override
//	public Camp findBoardByIdx(int boardIdx) {
//		//1. Board 조회
//		//2. BoardFile 조회
//		//3. Board에 BoardFile 저장
//		Camp board = boardMapper.selectBoardByIdx(boardIdx);
//		return board;
//	}
//
//	@Override
//	public CampFile findBoardFileByIdx(int fileIdx) {
//		CampFile file = boardMapper.selectBoardFileByIdx(fileIdx);
//		return file;
//	}
//
//	@Override
//	public void deleteBoard(int boardIdx) {
//		boardMapper.deleteBoard(boardIdx);
//	}
//
//	@Override
//	public void updateBoard(Camp board) {
//		boardMapper.updateBoard(board);	
//	}

}

