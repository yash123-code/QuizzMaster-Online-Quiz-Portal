package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Answers;

public interface AnswersRepository extends JpaRepository<Answers, Integer>{
	Answers findByansId(int ansId);
	//@Query(value="select iscorrect from answers where qid = ? and ansid = ?;",nativeQuery=true)
	// Answers findByqIdAndansId(int qId,int ansId);
	@Query(value="select * from answers a where a.qid = ?1",nativeQuery=true)
	List<Answers> findByQues(int id);
}
