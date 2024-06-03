package com.umc.study.service;

import com.umc.study.domain.Store;
import com.umc.study.dto.StoreRequestDTO;

public interface StoreService {
    Store addStoreToRegion(Long regionId, StoreRequestDTO storeRequestDTO);
}
