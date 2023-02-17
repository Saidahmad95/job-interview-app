package com.example.jobinterview.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.jobinterview.domain.Location;

public interface LocationRepo extends CrudRepository<Location,Long>{
   
}
