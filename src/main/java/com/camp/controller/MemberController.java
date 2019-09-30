package com.camp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camp.common.Util;
import com.camp.service.CampService;
import com.camp.service.MemberService;
import com.camp.service.ProductService;
import com.camp.vo.Buy;
import com.camp.vo.Member;
import com.camp.vo.Rent;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	CampService campService;
	
	@Autowired
	ProductService productService;
	
   @RequestMapping(path = "/mypage", method = RequestMethod.GET)
   public String mypage() {
      
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
	
/////////////////////////////////////////////주문 내역///////////////////////////////////////////////////////
	   @RequestMapping(path = "/orderlist", method = RequestMethod.GET)
	   public String orderList(Model model, String memberId) { 

		List<Rent> rents = memberService.orderList(memberId);
		
		List<Buy> buys = memberService.orderLists(memberId);
		
		for (Rent rent : rents) {
			rent.setFile(campService.findCampFile(rent.getCampNo()));
		}

		for (Buy buy : buys) {
			buy.setFile(productService.findProductFile(buy.getProductNo()));
		}		
		   
		model.addAttribute("rents", rents);
		model.addAttribute("buys", buys);		
		   
	      return "member/orderlist";
	   } 
	   
/////////////////////////////////////////////관리자 페이지///////////////////////////////////////////////////////
	   @RequestMapping(path = "/adminpage", method = RequestMethod.GET)
	   public String adminPage() {
	      
	      return "member/adminpage";
	   }
	   
		@RequestMapping(path = "/memberlist", method = RequestMethod.GET)
		public String memberList(Model model) {
			
			List<Member> members = memberService.findMemberList();
			
			model.addAttribute("members", members);
			return "member/memberlist";
		}
		
/////////////////////////////////////////////레포팅 페이지///////////////////////////////////////////////////////
		//구매자별 레포팅
		@RequestMapping(path = "/reporting", method = RequestMethod.GET)
		public String ReportingForm(Model model) {
			
			List<Member> report = memberService.reporting();
			
		    model.addAttribute("reports", report);
				
			return "member/reporting";
			
		}
}