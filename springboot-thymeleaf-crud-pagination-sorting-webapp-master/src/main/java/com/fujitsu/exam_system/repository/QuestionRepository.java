package com.fujitsu.exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fujitsu.exam_system.model.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long>{
	/*
	 * @Query(value = "select * from questiontbl s where s.id = :id", nativeQuery =
	 * true) List<QuestionModel> viewByexamId(@Param("id") long id);
	 */

}
