package com.camp.service;

import java.util.List;

import com.camp.vo.QnA;
import com.camp.vo.QnAComment;

public interface QnAService {

	List<QnA> findAllQnA();

	void uploadQnA(QnA qna);

	void deleteQna(int qaNo);

	QnA findQnABoardbyIdx(int qaNo);

	/* ===================================*/
	


	List<QnAComment> findQnAAnswer(int qaNo);
	
	void writeComment(QnAComment qnaComment);

//	void deleteAnswer(String sendData);

	

}
