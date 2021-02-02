package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.ExamDetails;
import com.app.pojos.Tests;
import com.app.pojos.Users;
import com.app.repository.ExamDetailsRepository;

@Service
@Transactional
public class ExamDetailsServiceImpl implements IExamDetailsService {

	@Autowired
	private ExamDetailsRepository dao;
	@Autowired
	private ITestService tdao;
	@Autowired
	private IUserService udao;

	@Override
	public List<ExamDetails> getAllExamDetails() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public ExamDetails getExamDetailsById(int examId) {
		return dao.findByExamId(examId);
	}

	@Override
	public ExamDetails addExamDetails(ExamDetails p) {
		Tests m = tdao.getTestsDetailsById(p.getE2().getTestId());
		Users n = udao.getUserDetailsById(p.getE3().getUserId());
		ExamDetails ed = new ExamDetails();
		ed.setTotalQue(p.getTotalQue());
		ed.setTotalMarks(p.getTotalMarks());
		
		ed.setE2(m);
		ed.setE3(n);
		return dao.save(ed);
	}

	@Override
	public ExamDetails updateExamDetails(int examId, ExamDetails p1) {
		ExamDetails ed = dao.findByExamId(examId);
		if (ed != null) {
			ExamDetails ExDet = ed;
			ExDet.setTotalQue(p1.getTotalQue());
			ExDet.setTotalMarks(p1.getTotalMarks());
			

			return ExDet;

		}
		throw new ResourceNotFoundException("Invalid  ID");

	}

	@Override
	public String deleteExamDetails(int examId) {
		dao.deleteById(examId);
		return "ExamDetails with ID="+examId+" is now deleted.";
	}

}
