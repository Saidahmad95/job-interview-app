package com.example.jobinterview.dto.request;

import lombok.Data;

@Data
public class InterviewReqDto {
    private String interviewType;
    private Long locationId;
    private Long templateId;
}
