package com.umc.study.converter;

import com.umc.study.domain.Review;
import com.umc.study.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.reviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.reviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
