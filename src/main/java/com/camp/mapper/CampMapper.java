package com.camp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Camp;

@Mapper //이 인터페이스의 패키지와 인터페이스 이름은 member-mapper.xml 파일의 namespace와 일치
public interface CampMapper {
	
	List<Camp> getCampList();
	
	List<Camp> getCampKind(String category);
		
}
