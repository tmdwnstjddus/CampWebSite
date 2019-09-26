package com.camp.mapper;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Member;

@Mapper
public interface MemberMapper {

	void registerMember(Member member);

	Member idCheck(String memberId);
	
	Member loginMember(HashMap<String, Object> params);
	   
	String idfind(HttpServletResponse response, String email) throws Exception;
	
	Member getMemberById(String memberId);
	
	void updateMember(Member member);

}
