package com.umc.study.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class StoreRequestDTO {
    private String name;
    private String address;
}
