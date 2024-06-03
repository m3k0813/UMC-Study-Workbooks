package com.umc.study.converter;

import com.umc.study.domain.Store;
import com.umc.study.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.storeResultDTO toStoreResultDTO(Store store) {
        return StoreResponseDTO.storeResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
