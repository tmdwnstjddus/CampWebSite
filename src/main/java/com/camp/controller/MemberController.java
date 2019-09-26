package com.camp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camp.common.Util;
import com.camp.service.MemberService;
import com.camp.vo.Member;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
   @RequestMapping(path = "/mypage", method = RequestMethod.GET)
   public String mypageList() {
      
      return "member/mypage";
   }
   
	@RequestMapping(path = "/memberset", method = RequestMethod.GET)
	public String memberSetForm(@RequestParam(name="memberId") String memberId, Model model) {
		Member member = memberService.getMemberById(memberId);
		model.addAttribute("member",member);
		return "member/memberset";
	}
	
	
	@RequestMapping(path = "/memberset", method = RequestMethod.POST)
	public String memberSet(HttpServletRequest req, Member member) {
		
		String memberId = req.getParameter("memberId");
		String pwd = req.getParameter("pwd");
		String confirm = req.getParameter("confirm");
		
		if (!pwd.equals(confirm)) {
			return "redirect:/member/memberset?memberId="+memberId;
		}	
		pwd = Util.getHashedString(pwd, "SHA-256");
		
		member.setMemberId(memberId);
		member.setPwd(pwd);
		memberService.updateMember(member);
		
		return "redirect:/member/mypage?memberId="+memberId;
	}
	
	
	   @RequestMapping(path = "/orderlist", method = RequestMethod.GET)
	   public String orderList() {
	      
	      return "member/orderlist";
	   }
}