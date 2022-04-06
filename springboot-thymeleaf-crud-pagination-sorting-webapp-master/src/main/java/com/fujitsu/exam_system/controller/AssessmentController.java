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
import com.fujitsu.exam_system.service.AssessmentService;

@Controller
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "examTitle", "asc", model);	
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		AssessmentModel assessmentModel = new AssessmentModel();
		model.addAttribute("employee", assessmentModel);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") AssessmentModel assessmentModel) {
		// save employee to database
		assessmentService.saveEmployee(assessmentModel);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		AssessmentModel assessmentModel = assessmentService.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", assessmentModel);
		return "update";
	}
	
//	@GetMapping("/deleteEmployee/{id}")
	@RequestMapping(value="/deleteEmployee/{id}", method = {RequestMethod.DELETE, RequestMethod.GET} )
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.assessmentService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 100;
		
		Page<AssessmentModel> page = assessmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<AssessmentModel> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listEmployees", listEmployees);
		
		return "index";
	}
}
