package com.umc.study.service;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.dto.MissionRequestDTO;
import com.umc.study.repository.MissionRepository;
import com.umc.study.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Mission addMissionToStore(Long storeId, MissionRequestDTO missionRequestDTO) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        Mission mission = Mission.builder()
                .missionSpec(missionRequestDTO.getMissionSpec())
                .deadline(LocalDate.from(missionRequestDTO.getDeadline()))
                .reward(missionRequestDTO.getReward())
                .build();

        return missionRepository.save(mission);
    }
}
