package com.camp.service;

import javax.servlet.http.HttpServletResponse;

import com.camp.vo.Member;

public interface MemberService {
	
	Member loginMember(String memberId, String pwd);

	String idfind(HttpServletResponse response, String email) throws Exception;

	void registerMember(Member member);

	Member idCheck(String memberId);
	

}
