package com.umc.study.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MissionRequestDTO {
    private String missionSpec;
    private LocalDateTime deadline;
    private int reward;
}