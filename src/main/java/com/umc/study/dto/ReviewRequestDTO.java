package com.umc.study.dto;

import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Text;

@Data
@Builder
public class ReviewRequestDTO {
    private String title;
    private String content;
    private float score;
}
