package com.camp.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.camp.vo.Buy;
import com.camp.vo.Camp;
import com.camp.vo.Member;
import com.camp.vo.Rent;

public interface MemberService {
	
	Member loginMember(String memberId, String pwd);

	String idfind(HttpServletResponse response, String email) throws Exception;

	void registerMember(Member member);

	Member idCheck(String memberId);

	void updateMember(Member member);

	Member getMemberById(String memberId);

	List<Member> findMemberList();

	List<Member> reporting();

	List<Rent> orderList(String memberId);

	List<Buy> orderLists(String memberId);

}
