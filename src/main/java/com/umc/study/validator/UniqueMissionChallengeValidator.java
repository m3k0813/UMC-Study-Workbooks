package com.umc.study.validator;

import com.umc.study.validation.UniqueMissionChallenge;
import com.umc.study.dto.MissionChallengeRequestDTO;
import com.umc.study.repository.MissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueMissionChallengeValidator implements ConstraintValidator<UniqueMissionChallenge, MissionChallengeRequestDTO> {

    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(MissionChallengeRequestDTO dto, ConstraintValidatorContext context) {
        return !missionRepository.existsByStoreIdAndId(dto.getStoreId(), dto.getMissionId());
    }
}