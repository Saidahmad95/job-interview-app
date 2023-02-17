package com.example.jobinterview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobinterview.domain.Interview;
import com.example.jobinterview.domain.InterviewType;
import com.example.jobinterview.domain.Location;
import com.example.jobinterview.domain.Template;
import com.example.jobinterview.dto.request.InterviewReqDto;
import com.example.jobinterview.exception.domain.InterviewNotFoundException;
import com.example.jobinterview.exception.domain.InterviewTypeNotFoundException;
import com.example.jobinterview.exception.domain.LocationNotFoundException;
import com.example.jobinterview.exception.domain.TemplateNotFoundException;
import com.example.jobinterview.repos.InterviewRepo;
import com.example.jobinterview.repos.InterviewTypeRepo;
import com.example.jobinterview.repos.LocationRepo;
import com.example.jobinterview.repos.TemplateRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InterviewService {

    private final InterviewRepo interviewRepo;
    private final TemplateRepo templateRepo;
    private final LocationRepo locationRepo;
    private final InterviewTypeRepo interviewTypeRepo;

    public ResponseEntity<Interview> getOneInterview(Long id) {
        Optional<Interview> findById = interviewRepo.findById(id);
        if (findById.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(findById.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviews = interviewRepo.findAll();
        return ResponseEntity.status(interviews.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(interviews);
    }

    public ResponseEntity<Interview> createInterview(InterviewReqDto iDto)
            throws LocationNotFoundException, TemplateNotFoundException, InterviewTypeNotFoundException {
        Location location = locationRepo
                .findById(iDto.getLocationId())
                .orElseThrow(() -> new LocationNotFoundException());

        Template template = templateRepo
                .findById(iDto.getTemplateId())
                .orElseThrow(() -> new TemplateNotFoundException());

        InterviewType interviewType = interviewTypeRepo
                .findByName(iDto.getInterviewType())
                .orElseThrow(() -> new InterviewTypeNotFoundException());

        Interview interview = new Interview(
                interviewType,
                location,
                template);

        Interview savedInterview = interviewRepo.save(interview);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInterview);
    }

    public ResponseEntity<Interview> editInterview(Long interviewId) throws InterviewNotFoundException {
       Interview interview = interviewRepo
                .findById(interviewId)
                .orElseThrow(() -> new InterviewNotFoundException());
                //TO-DO: chala
        return null;
    }

}
