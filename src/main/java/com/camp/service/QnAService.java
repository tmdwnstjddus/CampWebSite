package com.camp.service;

import java.util.List;

import com.camp.vo.QnA;

public interface QnAService {

	List<QnA> findAllQnA();

	void uploadQnA(QnA qna);

	void deleteQna(int qaNo);

	QnA findQnABoardbyIdx(int qaNo);
	

}
