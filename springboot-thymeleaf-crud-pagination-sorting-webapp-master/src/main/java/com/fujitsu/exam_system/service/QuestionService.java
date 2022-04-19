package com.fujitsu.exam_system.service;

import java.util.List;
import com.fujitsu.exam_system.model.QuestionModel;



public interface QuestionService {
	
	
	List<QuestionModel> getAllQuestion();
	
	QuestionModel getQuestionById(long id);
	void deleteQuestionById(long id);
	void saveQuestion(QuestionModel questionModel);
	
	
	

}
