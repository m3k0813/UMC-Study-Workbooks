package com.umc.study.repository;

import com.umc.study.domain.Mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>{
    Optional<MemberMission> findByMissionId(Long missionId);
}
