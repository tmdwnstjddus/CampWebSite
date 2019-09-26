package com.camp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.CampMapper;
import com.camp.vo.Camp;

@Service
public class CampServiceImpl implements CampService {
	
//	private SqlSessionTemplate sessionTemplate;
//	
//	public SqlSessionTemplate getSessionTemplate() {
//		return sessionTemplate;
//	}
//
//	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
//		this.sessionTemplate = sessionTemplate;
//	}
	
	@Autowired
	private CampMapper campMapper;
	

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
	
	


	
}
