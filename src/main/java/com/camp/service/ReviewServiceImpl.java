package com.camp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.camp.mapper.ReviewMapper;
import com.camp.vo.CampFile;
import com.camp.vo.Criteria;
import com.camp.vo.Rental;
import com.camp.vo.Review;
import com.camp.vo.ReviewFile;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public void writeReview(Review review) {
		reviewMapper.insertReview(review);
		int newReviewNo = review.getReviewNo();
		
//		대표이미지
		ReviewFile titleFile = review.getFile();
		titleFile.setReviewNo(newReviewNo);
		reviewMapper.insertReviewFile(titleFile);
		
	}

	@Override
	public Review findReviewByReviewNo(int reviewNo) {
		Review review = reviewMapper.selectReviewByReviewNo(reviewNo);
		return review;
	}

	@Override
	public ReviewFile findReviewFile(int reviewNo) {
		ReviewFile file = reviewMapper.selectReviewFile(reviewNo);
		return file;
	}

	@Override
	public void updateReviewFile(ReviewFile reviewFile) {
		reviewMapper.updateReviewFile(reviewFile);
		
	}

	@Override
	public void updateReivew(Review review) {
		reviewMapper.updateReview(review);
		
	}

	@Override
	public void deleteReview(int reviewNo) {
		reviewMapper.deleteReview(reviewNo);
		
	}

	@Override
	public ReviewFile findReviewFileByReviewFileNo(int reviewFileNo) {
		ReviewFile file = reviewMapper.selectReviewFileByReviewFileNo(reviewFileNo);
		return file;
	}

	@Override
	public void deleteReviewFile(int reviewFileNo) {
		reviewMapper.deleteReviewFile(reviewFileNo);
		
	}

	


}

