package com.camp.service;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.common.Util;
import com.camp.mapper.MemberMapper;
import com.camp.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void registerMember(Member member) {
		
		String pwd = Util.getHashedString(member.getPwd(), "SHA-256"); //패스워드 암호화 (복원불가능)
		member.setPwd(pwd);
		
		memberMapper.registerMember(member);
		
	}

	@Override
	public Member idCheck(String memberId) {
		
		return memberMapper.idCheck(memberId);

	}
	
	   @Override
	   public Member loginMember(String memberId, String pwd) {

	      pwd = Util.getHashedString(pwd, "SHA-256"); //암호화
	      
	      HashMap<String, Object> params = new HashMap<String, Object>();
	      params.put("memberId", memberId);
	      params.put("pwd", pwd);
	      Member member = memberMapper.loginMember(params);

	      return member;
	   }
	   
	   // 아이디 찾기
	   @Override
	   public String idfind(HttpServletResponse response, String email) throws Exception {
	      response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	      String memberId = memberMapper.idfind(response, email);
	      
	      if (memberId == null) {
	         out.println("<script>");
	         out.println("alert('가입된 아이디가 없습니다.');");
	         out.println("history.go(-1);");
	         out.println("</script>");
	         out.close();
	         return null;
	      } else {
	         return memberId;
	      }
	   }

}
