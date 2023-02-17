package com.example.jobinterview.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.jobinterview.domain.Template;

public interface TemplateRepo extends JpaRepository<Template,Long>{
    
}
