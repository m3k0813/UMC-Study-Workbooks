package com.umc.study.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.MissionConverter;
import com.umc.study.domain.Mission;
import com.umc.study.dto.MissionRequestDTO;
import com.umc.study.dto.MissionResponseDTO;
import com.umc.study.service.MissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.missionResultDTO> addMissionToStore(@PathVariable Long storeId, @RequestBody MissionRequestDTO missionRequestDTO) {
        Mission mission = missionService.addMissionToStore(storeId, missionRequestDTO);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }

    @PostMapping("/missions/{missionId}")
    public ApiResponse<Long> challengeMission(@PathVariable Long missionId) {
        Long id = missionService.challengeMission(missionId);
        return ApiResponse.onSuccess(id);
    }

}