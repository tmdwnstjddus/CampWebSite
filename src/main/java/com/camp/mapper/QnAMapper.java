package com.camp.mapper;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.QnA;

@Mapper
public interface QnAMapper {

	void uploadQnA(QnA qna);
	void deleteQnA(int qaNo);
	List<QnA> selectQnA();
	QnA selectQnABoardByIdx(int qaNo);


}
