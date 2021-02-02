package com.app.service;

import java.util.List;

import com.app.pojos.Questions;

public interface IQuestionService {
	List<Questions> getAllQuestions();

	// get details by id
	Questions getQuestionsDetailsByQId(int qId);

	// add new details
	Questions addQuestionsDetails(Questions transientPOJO);

	// update existing details
	Questions updateQuestionsDetails(int qId, Questions detachedPOJO);

	String deleteQuestions(int qId);
	
	List<Questions> findByTest1(int tId);
}
