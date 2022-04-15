package com.fujitsu.exam_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fujitsu.exam_system.model.AssessmentModel;
import com.fujitsu.exam_system.model.QuestionModel;
import com.fujitsu.exam_system.service.AssessmentService;
import com.fujitsu.exam_system.service.QuestionService;

@Controller
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;
	
	@Autowired
	private QuestionService questionService;
	 
	
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "examTitle", "asc", model);		
	}
	
	
	
	/*
	 * @GetMapping("/showNewEmployeeForm") public String showNewEmployeeForm(Model
	 * model) { // create model attribute to bind form data AssessmentModel
	 * assessmentModel = new AssessmentModel(); model.addAttribute("employee",
	 * assessmentModel); return "new_employee"; }
	 */
	
	
	
	
//	@RequestMapping(value="/saveAssessment/{id}", method = {RequestMethod.PUT, RequestMethod.GET} )
	@PostMapping("/saveAssessment")
	public String saveAssessment(@ModelAttribute("assessment") AssessmentModel assessmentModel, QuestionModel questionModel) {
//	public String saveAssessment(@PathVariable (value = "id") long id, Model model) {		
		
		questionService.saveQuestion(questionModel);
		assessmentService.saveAssessment(assessmentModel);
		return "redirect:/";
	}
	
	
	
	
	
	/*
	 * @PostMapping("/saveQuestion") public String
	 * saveQuestion(@ModelAttribute("question") QuestionModel questionModel) { //
	 * public String saveAssessment(@PathVariable (value = "id") long id, Model
	 * model) { // save employee to database
	 * 
	 * 
	 * return "update"; }
	 */
	
	
	
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id" ) long id, Model model)		{		
		
	// get employee from the service
		AssessmentModel assessmentModel = assessmentService.getAssessmentById(id);
		QuestionModel questionModel = questionService.getQuestionById(id);

		List<QuestionModel> questionList = questionService.getAllQuestion();
		
		// set question and assessment as a model attribute to pre-populate the form
		model.addAttribute("question", questionModel);
		System.out.print("questionMethod: " + questionList.get(0).getId());
		model.addAttribute("assessment", assessmentModel);
		return "update";
	}
	
//	@GetMapping("/deleteEmployee/{id}")
	@RequestMapping(value="/deleteAssessment/{id}", method = {RequestMethod.DELETE, RequestMethod.GET} )
	public String deleteAssessment(@PathVariable (value = "id") long id) {
		
		// call delete assessment method 
		
		this.assessmentService.deleteAssessmentById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteQuestion/{id}", method = {RequestMethod.DELETE, RequestMethod.GET} )
	public String deleteQuestion(@PathVariable (value = "id") long id) {
		
		// call delete question method 
		this.questionService.deleteQuestionById(id);
		
		return "update";
	}
	

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 100;
		
		Page<AssessmentModel> page = assessmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<AssessmentModel> listAssessment = page.getContent();	
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());	
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listAssessment", listAssessment);
		
		System.out.print("LIST ASSESSMENT: " + listAssessment.get(0).getId());
		return "index";
	}
}
