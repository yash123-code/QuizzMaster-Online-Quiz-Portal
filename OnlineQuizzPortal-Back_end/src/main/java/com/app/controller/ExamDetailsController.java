package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.ExamDetails;
import com.app.pojos.Tests;
import com.app.pojos.Users;
import com.app.repository.ExamDetailsRepository;
import com.app.repository.TestRepository;
import com.app.repository.UserRepository;
import com.app.service.IExamDetailsService;
@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
@RequestMapping("/examdetails")
public class ExamDetailsController {
    @Autowired
    ExamDetailsRepository dao;
	@Autowired
     IExamDetailsService service;
     @Autowired
     TestRepository testRepo;
     @ Autowired
     UserRepository userRepo;
	@GetMapping
	@CrossOrigin(origins= {"http://localhost:4200"})
	public ResponseEntity<?> listAllExamDetails() {
		System.out.println("in list all ");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<ExamDetails> ed = service.getAllExamDetails();
		if (ed.isEmpty())
			// empty list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return ResponseEntity.ok(ed); // 200 ok
	}

	@CrossOrigin(origins= {"http://localhost:4200"}) 
	@PostMapping("/{userId}/{testId}")
	public ExamDetails exam(@PathVariable int testId,@PathVariable int userId,
    @RequestBody ExamDetails exam) throws ResourceNotFoundException {
     Tests test=testRepo.findByTestId(testId);
     Users user=userRepo.findByUserId(userId);
     System.out.println("yash:"+exam);
     exam.setE2(test);
     exam.setE3(user);
     dao.save(exam);
     return exam;
	}
}
	
	
	

