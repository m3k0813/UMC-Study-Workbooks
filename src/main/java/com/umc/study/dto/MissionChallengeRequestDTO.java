package com.umc.study.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MissionChallengeRequestDTO {
    @NotNull(message = "Member ID cannot be null")
    private Long storeId;

    @NotNull(message = "Mission ID cannot be null")
    private Long missionId;
}