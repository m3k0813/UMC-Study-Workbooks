package com.umc.study.service;

import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.dto.ReviewRequestDTO;
import com.umc.study.repository.ReviewRepository;
import com.umc.study.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review addReviewToStore(Long storeId, ReviewRequestDTO reviewRequestDTO) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        Review review = Review.builder()
                .title(reviewRequestDTO.getTitle())
                .content(reviewRequestDTO.getContent())
                .score(reviewRequestDTO.getScore())
                .build();

        return reviewRepository.save(review);
    }
}