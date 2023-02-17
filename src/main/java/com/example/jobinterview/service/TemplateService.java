package com.example.jobinterview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobinterview.domain.Template;
import com.example.jobinterview.repos.TemplateRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TemplateService {

    private final TemplateRepo templateRepo;

    public ResponseEntity<List<Template>> getaAllTemplates() {
        List<Template> templates = templateRepo.findAll();
        return ResponseEntity.status(templates.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(templates);
    }

    public ResponseEntity<Template> getOneTemplateByid(Long id) {
        Optional<Template> findById = templateRepo.findById(id);
        if(findById.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(findById.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
