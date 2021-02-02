package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Questions;
import com.app.pojos.QuestionsResp;
import com.app.pojos.Tests;
import com.app.pojos.Users;
import com.app.repository.QuestionRespRepository;

@Service
@Transactional
public class QuestionRespServiceImpl implements IQuestionRespService {

	@Autowired
	private QuestionRespRepository dao;
	@Autowired
	private IUserService udao;
	@Autowired
	private IQuestionService qdao;
	@Autowired
	private ITestService tdao;

	@Override
	public List<QuestionsResp> getAllQuestionsResp() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public QuestionsResp getQuestionsRespDetailsByQRId(int QRId) {
		return dao.findByQRId(QRId);
	}

	@Override
	public QuestionsResp addQuestionsRespDetails(QuestionsResp p) {
		Users m = udao.getUserDetailsById(p.getUs().getUserId());
		Questions q = qdao.getQuestionsDetailsByQId(p.getQue().getqId());
		Tests t=tdao.getTestsDetailsById(p.getQrs().getTestId());
		QuestionsResp qr = new QuestionsResp();
		qr.setAns(p.getAns());
		qr.setRespDate(p.getRespDate());
        qr.setQrs(t);
		qr.setUs(m);
		qr.setQue(q);
		return dao.save(qr);
	}

	@Override
	public QuestionsResp updateQuestionsRespDetails(int QRId, QuestionsResp p1) {
		QuestionsResp qr = dao.findByQRId(QRId);
		if (qr != null) {
			QuestionsResp QResp = qr;
			QResp.setAns(p1.getAns());
			QResp.setRespDate(p1.getRespDate());
			return QResp;
		}
		throw new ResourceNotFoundException("Invalid  QRId");
	}

	@Override
	public String deleteQuestionsResp(int QRId) {
		dao.deleteById(QRId);
		return "Question with ID=" + QRId + "deleted.";
	}

}
