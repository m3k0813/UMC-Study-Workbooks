package com.umc.study.service;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import com.umc.study.apiPayload.exception.handler.MissionHandler;
import com.umc.study.domain.Mapping.MemberMission;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.dto.MissionRequestDTO;
import com.umc.study.repository.MemberMissionRepository;
import com.umc.study.repository.MissionRepository;
import com.umc.study.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;

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

    @Transactional
    public Long challengeMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        Optional<MemberMission> memberMission = memberMissionRepository.findByMissionId(missionId);

        if (!memberMission.isPresent()) {
            MemberMission newMemberMission = MemberMission.builder()
                    .mission(mission)
                    .status(MissionStatus.CHALLENGING)
                    .build();
            return memberMissionRepository.save(newMemberMission).getId();
        }

        if (memberMission.get().getStatus()==MissionStatus.COMPLETE){
            throw  new MissionHandler(ErrorStatus.MISSION_STATUS_COMPLETE);
        }

        if (memberMission.get().getStatus()==MissionStatus.CHALLENGING) {
            throw  new MissionHandler(ErrorStatus.MISSION_STATUS_CHALLENGING);
        }
        return memberMission.get().getId();
    }
}
