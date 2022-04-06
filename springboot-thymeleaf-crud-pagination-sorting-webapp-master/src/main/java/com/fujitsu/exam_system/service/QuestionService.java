package com.fujitsu.exam_system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fujitsu.exam_system.model.AssessmentModel;
import com.fujitsu.exam_system.model.QuestionModel;



public interface QuestionService {
	
	
	List<QuestionModel> getAllQuestion();
	
	QuestionModel getQuestionById(int id);
	void deleteQuestionById(int id);
	
	
	

}
