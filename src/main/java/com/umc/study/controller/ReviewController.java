package com.umc.study.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.ReviewConverter;
import com.umc.study.converter.StoreConverter;
import com.umc.study.domain.Review;
import com.umc.study.dto.ReviewRequestDTO;
import com.umc.study.dto.ReviewResponseDTO;
import com.umc.study.dto.StoreResponseDTO;
import com.umc.study.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stores")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.reviewResultDTO> addReviewToStore(@PathVariable Long storeId, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewService.addReviewToStore(storeId, reviewRequestDTO);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO((review)));
    }
}