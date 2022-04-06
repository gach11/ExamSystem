package com.fujitsu.exam_system.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fujitsu.exam_system.model.AssessmentModel;

public interface AssessmentService {
	List<AssessmentModel> getAllEmployees();
	void saveEmployee(AssessmentModel assessmentModel);
	AssessmentModel getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<AssessmentModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
