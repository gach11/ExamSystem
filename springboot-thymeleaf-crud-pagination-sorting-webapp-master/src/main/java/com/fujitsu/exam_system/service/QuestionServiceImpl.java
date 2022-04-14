package com.fujitsu.exam_system.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fujitsu.exam_system.model.QuestionModel;
import com.fujitsu.exam_system.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public List<QuestionModel> getAllQuestion() {				
		return questionRepository.findAll();
	}

	@Override
	public QuestionModel getQuestionById(long id) {
		Optional<QuestionModel> optional = questionRepository.findById(id);
		QuestionModel question = null;
		if (optional.isPresent()) {
		question = optional.get();
		} else {
		throw new RuntimeException("QuestionServiceImp not found for id :: " + id);
		}
		return question;
	}

	

	@Override
	public void saveQuestion(QuestionModel questionModel) {
		this.questionRepository.save(questionModel);
		
	}

	
	@Override
	public Page<QuestionModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestionById(long id) {
		this.questionRepository.deleteById(id);
		
	}
	
	

}
