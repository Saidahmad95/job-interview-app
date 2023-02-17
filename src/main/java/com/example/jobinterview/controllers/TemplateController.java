package com.example.jobinterview.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobinterview.domain.Template;
import com.example.jobinterview.service.TemplateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/template")
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping("/all")
    public ResponseEntity<List<Template>> getAllTemplates() {
        return templateService.getaAllTemplates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getOneTemplateByid(@PathVariable Long id) {
        return templateService.getOneTemplateByid(id);
    }
    
    // @PostMapping
    // public ResponseEntity<Template> addNewTemplate(@RequestBody ){

    // }
}
