package com.xworkz.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.task.entity.TelevisionEntity;

@Repository
public interface TelevisionRepo extends JpaRepository<TelevisionEntity, Integer>{
	
	

}
