package com.fujitsu.exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fujitsu.exam_system.model.AssessmentModel;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentModel, Long>{

}
