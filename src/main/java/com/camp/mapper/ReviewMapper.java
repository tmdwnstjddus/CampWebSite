package com.camp.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.vo.Camp;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;
import com.camp.vo.Rental;
import com.camp.vo.Review;
import com.camp.vo.ReviewFile;

@Mapper
public interface ReviewMapper {

	void insertReview(Review review);

	void insertReviewFile(ReviewFile titleFile);

	Review selectReviewByReviewNo(int reviewNo);

	ReviewFile selectReviewFile(int reviewNo);

	void updateReviewFile(ReviewFile reviewFile);

	void updateReview(Review review);

	void deleteReview(int reviewNo);

	ReviewFile selectReviewFileByReviewFileNo(int reviewFileNo);

	void deleteReviewFile(int reviewFileNo);

	
		
}
