package com.fujitsu.exam_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fujitsu.exam_system.model.AssessmentModel;
import com.fujitsu.exam_system.repository.AssessmentRepository;

@Service
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentRepository assessmentRepository;

	@Override
	public List<AssessmentModel> getAllAssessment() {
		return assessmentRepository.findAll();
	}

	@Override
	public void saveAssessment(AssessmentModel assessmentModel) {
		this.assessmentRepository.save(assessmentModel);
	}

	@Override
	public AssessmentModel getAssessmentById(long id) {
		Optional<AssessmentModel> optional = assessmentRepository.findById(id);
		AssessmentModel assessmentModel = null;
		if (optional.isPresent()) {
			assessmentModel = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return assessmentModel;
	}

	@Override
	public void deleteAssessmentById(long id) {
		this.assessmentRepository.deleteById(id);
	}

	@Override
	public Page<AssessmentModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.assessmentRepository.findAll(pageable);
	}
}
