package com.example.jobinterview.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobinterview.domain.Interview;
import com.example.jobinterview.dto.request.InterviewReqDto;
import com.example.jobinterview.exception.domain.InterviewNotFoundException;
import com.example.jobinterview.exception.domain.InterviewTypeNotFoundException;
import com.example.jobinterview.exception.domain.LocationNotFoundException;
import com.example.jobinterview.exception.domain.TemplateNotFoundException;
import com.example.jobinterview.service.InterviewService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@AllArgsConstructor
@RestController
@RequestMapping("api/interview")
public class InterviewController {

    private final InterviewService interviewService;

    @GetMapping("/all")
    public ResponseEntity<List<Interview>> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    
    public ResponseEntity<Interview> getOneInterviewById(@PathVariable Long id) {
        return interviewService.getOneInterview(id);
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody InterviewReqDto interviewReqDto) throws LocationNotFoundException, TemplateNotFoundException, InterviewTypeNotFoundException {
      return interviewService.createInterview(interviewReqDto);

    }

    @PutMapping("/{interviewId}")
    public ResponseEntity<Interview> editInterview(
        @PathVariable Long interviewId,
        @RequestBody InterviewReqDto interviewReqDto) throws InterviewNotFoundException{
        return interviewService.editInterview(interviewId);
    }
    
}
