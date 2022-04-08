package com.fujitsu.exam_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questiontbl")
public class QuestionModel {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long question_id;
	
	@Column(name = "question_title")
	private String questionTitle;
	
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	@Column(name = "chosen_answer")
	private String chosenAnswer;

	

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(String chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	
	

}
