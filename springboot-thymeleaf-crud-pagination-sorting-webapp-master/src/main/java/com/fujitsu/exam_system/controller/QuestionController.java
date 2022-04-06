package com.fujitsu.exam_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		// get employee from the service
		QuestionModel questionModel = questionService.getQuestionById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", questionModel);
		return "update";
	}
	
	
	
	

}
