package com.camp.mapper;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.QnA;
import com.camp.vo.QnAComment;

@Mapper
public interface QnAMapper {

	void uploadQnA(QnA qna);
	void deleteQnA(int qaNo);
	List<QnA> selectQnA();
	QnA selectQnABoardByIdx(int qaNo);
	
	
	/* comment */
	void insertQnAComment(QnAComment qnaComment);
	//void insertQnAComment(String json);
	
	
	List<QnAComment> selectComment(int qaNo);
	void setCompleted(int qaNo);
	
	void dropQnAComment(int qaNo);
	void setDecompleted(int qaNo);
	

}
