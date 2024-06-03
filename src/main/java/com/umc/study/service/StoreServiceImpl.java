package com.umc.study.service;

import com.umc.study.domain.Region;
import com.umc.study.domain.Store;
import com.umc.study.dto.StoreRequestDTO;
import com.umc.study.repository.RegionRepository;
import com.umc.study.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public Store addStoreToRegion(Long regionId, StoreRequestDTO storeRequestDTO) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));
        Store store = Store.builder()
                .name(storeRequestDTO.getName())
                .address(storeRequestDTO.getAddress())
                .region(region)
                .build();

        return storeRepository.save(store);
    }
}