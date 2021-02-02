package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Questions;
import com.app.pojos.QuestionsResp;
import com.app.pojos.Tests;
import com.app.pojos.Users;
import com.app.repository.QuestionRepository;
import com.app.repository.QuestionRespRepository;
import com.app.repository.TestRepository;
import com.app.repository.UserRepository;
import com.app.service.IQuestionRespService;
@RestController // => @Controller at class level +
// @ResponseBody annotation added on ret types of all req handling methods
@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
@RequestMapping("/queresp")
public class QuestionRespController {
        @Autowired
        QuestionRespRepository dao;
		@Autowired
		private IQuestionRespService service;
		@Autowired
        QuestionRepository queRepo;
		@Autowired
		UserRepository userRepo;
		@Autowired
		TestRepository testRepo;
	public QuestionRespController() {
		System.out.println("in ctor of " + getClass().getName());
	}

		// RESTful end point or API end point or API provider
		@GetMapping
		@CrossOrigin(origins= {"http://localhost:4200"})
		public ResponseEntity<?> listAllQuestionsResp() {
			System.out.println("in list all ");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<QuestionsResp> que = service.getAllQuestionsResp();
			if (que.isEmpty())
				// empty list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return ResponseEntity.ok(que); // 200 ok
		}

		// get prduct details by its name : supplied by clnt using path var
		@GetMapping("/{}")
		@CrossOrigin(origins= {"http://localhost:4200"})
		public ResponseEntity<?> getQuestionsDetailsByQRId(@PathVariable int QRId) {
			System.out.println("in get  details " + QRId);
			// invoke service method
			QuestionsResp Details = service.getQuestionsRespDetailsByQRId(QRId);
			// valid name : HTTP 200 , marshalled center details
			if (Details != null)
				return ResponseEntity.ok(Details);
			// in case of invalid name : HTTP 404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		/*
		 * @GetMapping("/{userName}") public
		 * ResponseEntity<?>getUserDetails(@PathVariable String userName) {
		 * System.out.println("in get  details " + userName); // invoke s method User
		 * Details = service.getUserDetails(userName); //valid name : HTTP 200 ,
		 * marshalled center details if (Details!=null) return
		 * ResponseEntity.ok(Details); // in case of invalid name : HTTP404 return new
		 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */

		// add
		@PostMapping
		@CrossOrigin(origins= {"http://localhost:4200"})
		public ResponseEntity<?> addQuestionsRespDetails(@RequestBody @Valid QuestionsResp p) {
			System.out.println("in add center " + p);

			try {
				QuestionsResp c = service.addQuestionsRespDetails(p);
				return ResponseEntity.ok(c);

			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@CrossOrigin(origins= {"http://localhost:4200"}) 
		@PostMapping("/{qId}/{userId}/{testId}/")
		public QuestionsResp resp(@PathVariable int qId,@PathVariable int userId,@PathVariable int testId,
	    @RequestBody @Valid QuestionsResp response) throws ResourceNotFoundException {
	     Questions que=queRepo.findByqId(qId);
	     System.out.println("yash"+response);
	     Users user=userRepo.findByUserId(userId);
	     Tests test=testRepo.findByTestId(testId);
	     response.setQue(que);
	     response.setUs(user);
	     response.setQrs(test);
	     dao.save(response);
	     return response;
		}

		// update
		@PutMapping("/{QRId}")
		@CrossOrigin(origins= {"http://localhost:4200"})
		public ResponseEntity<?> updateQuestionsRespDetails(@PathVariable int QRId, @RequestBody QuestionsResp p) {
			System.out.println("in update " + QRId + " " + p);
			try {
				QuestionsResp updatedDetails = service.updateQuestionsRespDetails(QRId, p);
				return ResponseEntity.ok(updatedDetails);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		}

		@DeleteMapping("/{QRId}")
		@CrossOrigin(origins= {"http://localhost:4200"})
		public String deleteQuestionsResp(@PathVariable int QRId) {
			System.out.println("in delete queResp" + QRId);
			return service.deleteQuestionsResp(QRId);

		}
	}

