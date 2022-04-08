package com.fujitsu.exam_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fujitsu.exam_system.model.AssessmentModel;
import com.fujitsu.exam_system.model.QuestionModel;
import com.fujitsu.exam_system.service.QuestionService;

public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public String ViewHomepage(Model model) {
	List<QuestionModel> asessment = questionService.getAllQuestion();
	model.addAttribute("list", asessment );
	return "update";
	}
	
	@PostMapping("/saveQuestion")
	public String saveQuestion(@ModelAttribute("question") QuestionModel questionModel) {
		// save employee to database
		questionService.saveQuestion(questionModel);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormUpdate/{question_id}")
	public String showFormUpdate(@PathVariable ( value = "question_id") long question_id, Model model) {
		
		// get employee from the service
		QuestionModel questionModel = questionService.getQuestionById(question_id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("question", questionModel);
		return "update";
	}
	
	
	
	
	

}
