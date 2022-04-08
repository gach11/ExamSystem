package com.fujitsu.exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fujitsu.exam_system.model.QuestionModel;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long>{
	
	
	

}
