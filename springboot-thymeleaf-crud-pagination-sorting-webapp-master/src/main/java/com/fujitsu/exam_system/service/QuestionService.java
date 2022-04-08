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
	
	QuestionModel getQuestionById(long question_id);
	void deleteQuestionById(long question_id);

	void saveQuestion(QuestionModel questionModel);
	
	
	

}
