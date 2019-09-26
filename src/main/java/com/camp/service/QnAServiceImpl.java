package com.camp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.mapper.QnAMapper;
import com.camp.vo.QnA;

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


}
