package com.camp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.QnAMapper;
import com.camp.vo.QnA;
import com.camp.vo.QnAComment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnAMapper qnaMapper;

	@Override
	public void uploadQnA(QnA qna) {
		
		qnaMapper.uploadQnA(qna);
		
	}

	@Override
	public void deleteQna(int qaNo) {
		qnaMapper.deleteQnA(qaNo);
		
	}

	@Override
	public List<QnA> findAllQnA() {
		List<QnA> qnaList = qnaMapper.selectQnA();
		return qnaList;
	}

	@Override
	public QnA findQnABoardbyIdx(int qaNo) {
		
		QnA qna = qnaMapper.selectQnABoardByIdx(qaNo);
		return qna;
	}

	@Override
	public void answerQuestion(QnAComment qnaComment) {
		qnaMapper.insertQnAComment(qnaComment);
	}

	@Override
	public List<QnAComment> findQnAAnswer(int qaNo) {
		List<QnAComment> qnaComment = qnaMapper.selectComment(qaNo);
		return qnaComment;
	}





}
