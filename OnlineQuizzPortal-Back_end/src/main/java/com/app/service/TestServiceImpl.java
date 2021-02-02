package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Tests;
import com.app.repository.TestRepository;

@Service
@Transactional
public class TestServiceImpl implements ITestService {

	@Autowired
	private TestRepository dao;

	@Override
	public List<Tests> getAllTests() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Tests getTestsDetails(String testName) {
		return dao.findBytestName(testName);
	}

	@Override
	public Tests getTestsDetailsById(int testId) {
		return dao.findByTestId(testId);
	}

	@Override
	public Tests addTestsDetails(Tests transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Tests updateTestsDetails(int testId, Tests p1) {
		Tests p = dao.findByTestId(testId);
		if (p != null) {
			// p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by
			// clnt
			// change state of persistent POJO
			Tests test = p;
			test.setTestName(p1.getTestName());
			test.setTestDate(p1.getTestDate());
			test.setTestDuration(p1.getTestDuration());
			test.setQuestion(p1.getQuestion());
			test.setExamd2(p1.getExamd2());

			return test;

		}

		// in case of no Manager found : throw custom exception
		throw new ResourceNotFoundException("Invalid UserID");

	}

	@Override
	public String deleteTest(int testId) {
		dao.deleteById(testId);
		return "Test with ID=" + testId + " is now deleted.";
	}

}
