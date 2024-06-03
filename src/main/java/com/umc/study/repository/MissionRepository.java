package com.umc.study.repository;

import com.umc.study.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>{
    boolean existsByStoreIdAndId(Long storeId, Long missionId);
}
