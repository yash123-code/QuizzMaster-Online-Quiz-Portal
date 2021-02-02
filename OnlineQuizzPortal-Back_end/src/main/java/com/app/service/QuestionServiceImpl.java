package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Questions;
import com.app.pojos.Tests;
import com.app.repository.QuestionRepository;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private QuestionRepository dao;
	@Autowired
	private ITestService tdao;

	@Override
	public List<Questions> getAllQuestions() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Questions getQuestionsDetailsByQId(int qId) {
		return dao.findByqId(qId);
	}

	@Override
	public Questions addQuestionsDetails(Questions p) {
		Tests m = tdao.getTestsDetailsById(p.getTest1().getTestId());
		Questions c = new Questions();
		c.setQue(p.getQue());
		c.setMarks(p.getMarks());
		c.setTest1(m);
		return dao.save(c);
	}

	@Override
	public Questions updateQuestionsDetails(int qId, Questions p1) {
		Questions c = dao.findByqId(qId);
		if (c != null) {
			Questions que = c;
			que.setQue(p1.getQue());
			que.setMarks(p1.getMarks());
			return que;

		}
		throw new ResourceNotFoundException("Invalid  qId");

	}

	@Override
	public String deleteQuestions(int qId) {
		dao.deleteByqId(qId);
		return "Question with ID=" + qId + "deleted.";
	}
	@Override
	public List<Questions> findByTest1(int tId){
		return dao.findByTest1(tId);
	}

}
