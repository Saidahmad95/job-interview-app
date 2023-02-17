package com.example.jobinterview.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.jobinterview.domain.Interview;

public interface InterviewRepo extends JpaRepository<Interview,Long>{
    
}
