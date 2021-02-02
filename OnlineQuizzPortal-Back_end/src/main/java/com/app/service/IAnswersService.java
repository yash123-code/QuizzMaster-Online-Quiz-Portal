package com.app.service;

import java.util.List;

import com.app.pojos.Answers;

public interface IAnswersService {
	List<Answers>getAllAnswers();
	// get details by id
	Answers getAnswersDetailsByansId(int ansId);
	
	// add new details
	Answers addAnswersDetails(Answers transientPOJO);

	// update existing details
	Answers updateAnswersDetails(int qId, Answers detachedPOJO);

	String deleteAnswers(int ansId);

	List<Answers> findByQues(int id);
}
