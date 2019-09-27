package com.camp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.CampMapper;
import com.camp.vo.Camp;
import com.camp.vo.CampFile;

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
	

	@Override
	public List<Camp> findCampList() {
		
		List<Camp> camps = campMapper.getCampList();
		
		return camps;
		
	}


	@Override
	public List<Camp> findCampKind(String category) {
		
		List<Camp> camps = campMapper.getCampKind(category);
		return camps;
	}

	@Override
	public Integer registerCamp(Camp camp) {
		
		campMapper.insertCamp(camp);
		int newCampNo = camp.getCampNo();
		
//		대표이미지
		CampFile titleFile = camp.getFile();
		titleFile.setCampNo(newCampNo);
		campMapper.insertCampFile(titleFile);
		
		insertCampFiles(camp, newCampNo);
		
		return newCampNo;
		
	}
	
	@Override
	public void insertCampFiles(Camp camp, int campNo) {

//		이미지
		for (CampFile file : camp.getFileList()) {
			file.setCampNo(campNo);
			campMapper.insertCampFile(file);
		}
	}

	@Override
	public CampFile findCampFile(int campNo) {
		CampFile file = campMapper.selectCampFile(campNo);
		return file;
	}

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

