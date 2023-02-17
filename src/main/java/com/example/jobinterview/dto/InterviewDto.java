package com.example.jobinterview.dto;

import lombok.Data;

@Data
public class InterviewDto {
    private Long id;
    private Long locationId;
    private String interviewType;
    private String location;
}
