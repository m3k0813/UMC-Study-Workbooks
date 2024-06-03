package com.umc.study.service;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.dto.MissionRequestDTO;

public interface MissionService {
    Mission addMissionToStore(Long storeId, MissionRequestDTO missionRequestDTO);

     Long challengeMission(Long missionId);
}
