package com.umc.study.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.StoreConverter;
import com.umc.study.domain.Store;
import com.umc.study.dto.StoreRequestDTO;
import com.umc.study.dto.StoreResponseDTO;
import com.umc.study.service.StoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regions")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/{regionId}/stores")
    public ApiResponse<StoreResponseDTO.storeResultDTO> addStoreToRegion(@PathVariable Long regionId, @RequestBody StoreRequestDTO storeRequestDTO) {
        Store store = storeService.addStoreToRegion(regionId, storeRequestDTO);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }
}