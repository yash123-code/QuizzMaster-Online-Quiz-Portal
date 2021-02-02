package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.QuestionsResp;
@Repository
public interface QuestionRespRepository extends JpaRepository<QuestionsResp, Integer> {
	QuestionsResp findByQRId(int QRId);
}
