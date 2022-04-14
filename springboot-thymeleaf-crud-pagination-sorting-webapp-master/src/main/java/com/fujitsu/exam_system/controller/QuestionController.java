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
import org.springframework.web.bind.annotation.RequestParam;
import com.fujitsu.exam_system.model.QuestionModel;
import com.fujitsu.exam_system.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	/*
	 * @GetMapping("/") public String viewHomePage2(Model model) { return
	 * findPaginated2(1, "questionTitle", "asc", model);
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/saveQuestion") public String
	 * saveQuestion(@ModelAttribute("question") QuestionModel questionModel) { //
	 * save employee to database questionService.saveQuestion(questionModel); return
	 * "redirect:/"; }
	 * 
	 * 
	 * 
	 * @GetMapping("/showFormForUpdate2/{question_id}") public String
	 * showFormForUpdate2(@PathVariable ( value = "question_id") long question_id,
	 * Model model) {
	 * 
	 * // get employee from the service
	 * 
	 * QuestionModel questionModel = questionService.getQuestionById(question_id);
	 * model.addAttribute("question", questionModel);
	 * 
	 * // set employee as a model attribute to pre-populate the form
	 * 
	 * return "update"; }
	 * 
	 * 
	 * @GetMapping("/page/{pageNo}") public String findPaginated2(@PathVariable
	 * (value = "pageNo") int pageNo,
	 * 
	 * @RequestParam("sortField") String sortField,
	 * 
	 * @RequestParam("sortDir") String sortDir, Model model) { int pageSize = 100;
	 * 
	 * Page<QuestionModel> page = questionService.findPaginated(pageNo, pageSize,
	 * sortField, sortDir); List<QuestionModel> listQuestion = page.getContent();
	 * 
	 * model.addAttribute("currentPage", pageNo); model.addAttribute("totalPages",
	 * page.getTotalPages()); model.addAttribute("totalItems",
	 * page.getTotalElements());
	 * 
	 * model.addAttribute("sortField", sortField); model.addAttribute("sortDir",
	 * sortDir); model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc"
	 * : "asc"); model.addAttribute("listQuestion", listQuestion);
	 * System.out.print("listQuestion: " + listQuestion.get(0).getQuestionTitle());
	 * return "update"; }
	 */

}
