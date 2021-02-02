package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Questions;
import com.app.pojos.Tests;
@Repository
public interface QuestionRepository extends JpaRepository<Questions,Tests> {
	Questions findByqId(int qId);
	void deleteByqId(int qId);
	@Query(value="select * from questions q where q.testid = ?1",nativeQuery=true)
	List<Questions> findByTest1(int id);
	//@Query(value="insert into questions (qid,corrans,marks,qop1,qop2,qop3,qop4,ques,testid)values(?,?,?,?,?,?,?,?1)",nativeQuery = true)
	//Questions SaveByTest1(int id );
	Questions save(Questions question);
}
