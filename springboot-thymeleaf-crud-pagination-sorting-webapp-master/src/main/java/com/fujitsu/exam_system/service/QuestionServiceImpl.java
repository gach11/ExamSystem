package com.fujitsu.exam_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.exam_system.model.QuestionModel;
import com.fujitsu.exam_system.repository.QuestionRepository;

public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public List<QuestionModel> getAllQuestion() {				
		return questionRepository.findAll();
	}

	@Override
	public QuestionModel getQuestionById(long question_id) {
		Optional<QuestionModel> optional = questionRepository.findById(question_id);
		QuestionModel question = null;
		if (optional.isPresent()) {
		question = optional.get();
		} else {
		throw new RuntimeException(" Question not found for id :: " + question_id);
		}
		return question;
	}

	

	@Override
	public void saveQuestion(QuestionModel questionModel) {
		this.questionRepository.save(questionModel);
		
	}

	@Override
	public void deleteQuestionById(long question_id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
