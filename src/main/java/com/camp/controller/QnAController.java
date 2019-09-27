package com.camp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import com.camp.service.QnAService;
import com.camp.vo.QnA;
import com.camp.vo.QnAComment;

@Controller
@RequestMapping(path = "/qna")
public class QnAController {
	
	@Autowired
	QnAService qnaService;

	@RequestMapping(path = "/qna", method = RequestMethod.GET)
	public String qnaList(Model model) {
		
		List<QnA> qnaList = qnaService.findAllQnA();
		model.addAttribute("qnaList", qnaList);
		
		return "qna/qna";
	}
	
	@RequestMapping(path = "/qnawrite", method = RequestMethod.GET)
	public String qnaWriteForm() {
		
		return "qna/qnawrite";
	}
	
	@RequestMapping(path = "/qnawrite", method = RequestMethod.POST)
	public String qnaWrite(QnA qna,HttpServletRequest req ) {
		
		qnaService.uploadQnA(qna);
		
		return "redirect:/qna/qna";
	}
	
	@RequestMapping(path = "/qnadetail", method = RequestMethod.GET)
	public String qnaDetailPage(int qaNo, Model model) {
		
		QnA qna = qnaService.findQnABoardbyIdx(qaNo);
		if (qna == null) {
			return "redirect:/qna/qna";
		}
		model.addAttribute("qna",qna);
		
		List<QnAComment> qnacomments = qnaService.findQnAAnswer(qaNo);
		model.addAttribute("qnacomments", qnacomments);
		
		return "qna/qnadetail";
	}
	
	//게시물 삭제 - user
	@RequestMapping(path="/deletedqna/{qaNo}", method = RequestMethod.GET)
	public String qnaDelete(@PathVariable int qaNo) {
		qnaService.deleteQna(qaNo);
		
		return "redirect:/qna/qna";
	}
	
	//게시물 수정 - user
//	@RequestMapping(path = "/updateqna/{ qano }")
//	public String qnaUpdate(int qaNo, HttpServletRequest req) {
//		return null;
//	}
	
	//comment---------------------------------//
	
//	@RequestMapping(value="/answer", method =RequestMethod.POST)
//	@ResponseBody
//	private String qnaComment(QnAComment qnaComment) {
//		
//		qnaService.answerQuestion(qnaComment);
//		
//		return "success";
//	}
//	@RequestMapping(value="/qna-answer", method =RequestMethod.GET)
//	private String calledAnswer(int qaNo, Model model) {
//
//		List<QnAComment> comment = qnaService.findQnAAnswer(qaNo);
//		model.addAttribute("comment",comment);
//		
//		return "success";
//	}
	
	@RequestMapping(value = "/answerform", method = RequestMethod.POST )
	private String qnaComment(QnAComment qnaComment,HttpServletRequest req ) {
		
		qnaService.answerQuestion(qnaComment);
		
		return "redirect:/qna/qna";
	}


}
