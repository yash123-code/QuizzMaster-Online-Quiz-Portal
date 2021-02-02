package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Answers;
import com.app.pojos.Questions;
import com.app.repository.AnswersRepository;
@Service
@Transactional
public class AnswersServiceImpl implements IAnswersService {
     @Autowired
     AnswersRepository dao;
     @Autowired
     IQuestionService qdao;
     
 	@Override
 	public List<Answers> getAllAnswers() {
 		System.out.println("dao imple class " + dao.getClass().getName());
 		return dao.findAll();
 		}
 
	
	@Override
	public Answers getAnswersDetailsByansId(int ansId) {
		return dao.findByansId(ansId);
	}

	@Override
	public Answers addAnswersDetails(Answers p) {
		    Questions q = qdao.getQuestionsDetailsByQId(p.getQues().getqId());
			Answers c = new Answers();
			c.setAnswer(p.getAnswer());
			c.setIsCorrect(p.getIsCorrect());
			c.setQues(q);
			return dao.save(c);
		}
	@Override
	public Answers updateAnswersDetails(int ansId,Answers p1) {
		Answers c = dao.findByansId(ansId);
		if (c != null) {
			Answers ans = c;
			ans.setAnswer(p1.getAnswer());
			ans.setIsCorrect(p1.getIsCorrect());
			return ans;

		}
		throw new ResourceNotFoundException("Invalid  qId");

	}

	@Override
	public String deleteAnswers(int ansId) {
		dao.deleteById(ansId);
		return "Answer with ID=" + ansId + "deleted.";
	}
	@Override
	public List<Answers> findByQues(int qId){
		return dao.findByQues(qId);
	}

}

	


