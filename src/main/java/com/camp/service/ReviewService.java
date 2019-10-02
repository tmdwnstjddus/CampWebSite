package com.camp.service;

import com.camp.vo.Review;
import com.camp.vo.ReviewFile;

public interface ReviewService {

	void writeReview(Review review);

	Review findReviewByReviewNo(int reviewNo);

	ReviewFile findReviewFile(int reviewNo);

	void updateReviewFile(ReviewFile reviewFile);

	void updateReivew(Review review);

	void deleteReview(int reviewNo);

	ReviewFile findReviewFileByReviewFileNo(int reviewFileNo);

	void deleteReviewFile(int reviewFileNo);

	

}
