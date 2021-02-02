package com.app.service;

import java.util.List;

import com.app.pojos.QuestionsResp;

public interface IQuestionRespService {
	List<QuestionsResp> getAllQuestionsResp();

	// get details by id
	QuestionsResp getQuestionsRespDetailsByQRId(int QRId);

	// add new details
	QuestionsResp addQuestionsRespDetails(QuestionsResp transientPOJO);

	// update existing details
	QuestionsResp updateQuestionsRespDetails(int QRId, QuestionsResp detachedPOJO);

	// delete existing details
	String deleteQuestionsResp(int QRId);
}
