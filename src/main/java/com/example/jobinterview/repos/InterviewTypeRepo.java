package com.example.jobinterview.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobinterview.domain.InterviewType;

public interface InterviewTypeRepo extends JpaRepository<InterviewType,Long>{
    
Optional<InterviewType> findByName(String name) ;
}
