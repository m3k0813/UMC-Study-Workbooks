package com.umc.study.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.ReviewConverter;
import com.umc.study.domain.Review;
import com.umc.study.dto.ReviewRequestDTO;
import com.umc.study.dto.ReviewResponseDTO;
import com.umc.study.service.ReviewServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewServiceImpl reviewServiceImpl;

    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.reviewResultDTO> addReviewToStore(@PathVariable Long storeId, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewServiceImpl.addReviewToStore(storeId, reviewRequestDTO);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO((review)));
    }
}