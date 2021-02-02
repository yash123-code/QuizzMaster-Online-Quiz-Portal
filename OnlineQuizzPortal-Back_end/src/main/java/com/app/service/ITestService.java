package com.app.service;

import java.util.List;

import com.app.pojos.Tests;

public interface ITestService {
	List<Tests> getAllTests();

	// get details by first name
	Tests getTestsDetails(String testName);

	Tests getTestsDetailsById(int testId);

	// add new details
	Tests addTestsDetails(Tests transientPOJO);

	// update existing details
	Tests updateTestsDetails(int testId, Tests detachedPOJO);

	String deleteTest(int testId);
}
