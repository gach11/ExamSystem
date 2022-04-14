package com.fujitsu.exam_system.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fujitsu.exam_system.model.AssessmentModel;

public interface AssessmentService {
	List<AssessmentModel> getAllAssessment();
	void saveAssessment(AssessmentModel assessmentModel);
	AssessmentModel getAssessmentById(long id);
	void deleteAssessmentById(long id);
	Page<AssessmentModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
