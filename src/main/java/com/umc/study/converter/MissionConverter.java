package com.umc.study.converter;

import com.umc.study.domain.Mission;
import com.umc.study.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.missionResultDTO toMissionResultDTO(Mission mission) {
        return MissionResponseDTO.missionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
