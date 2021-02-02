package com.app.service;

import java.util.List;

import com.app.pojos.ExamDetails;

public interface IExamDetailsService {
	List<ExamDetails> getAllExamDetails();

	// get details by id
	ExamDetails getExamDetailsById(int examId);

	// add new details
	ExamDetails addExamDetails(ExamDetails transientPOJO);

	// update existing details
	ExamDetails updateExamDetails(int examId, ExamDetails detachedPOJO);

	// delete details
	String deleteExamDetails(int examId);

	
}
