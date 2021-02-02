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
import com.app.pojos.Tests;
import com.app.repository.QuestionRepository;
import com.app.repository.TestRepository;
import com.app.service.IQuestionService;

@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
	@RequestMapping("/que")
public class QuestionController  {
	@Autowired
	private IQuestionService service;
    @Autowired 
    QuestionRepository queRepo;
    @Autowired 
    TestRepository testRepo;

	public QuestionController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping
	public ResponseEntity<?> listAllQuestions() {
		System.out.println("in list all ");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Questions> que = service.getAllQuestions();
		if (que.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(que);  //200 ok
	}

	// get prduct details by its name : supplied by clnt using path var
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping("/{qId}")
	public ResponseEntity<?> getQuestionsDetailsByqId(@PathVariable int qId) {
	System.out.println("in get  details " + qId);
		// invoke service method
	Questions Details = service.getQuestionsDetailsByQId(qId);
		// valid name : HTTP 200 , marshalled center details
	if (Details!=null)
	return ResponseEntity.ok(Details);
		// in case of invalid name : HTTP 404
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping("/testId/{tId}")
	public ResponseEntity<?> getQuestionsDetailsBytId(@PathVariable int tId) {
		System.out.println("in get  details " + tId);
			// invoke service method
		List<Questions> Details = service.findByTest1(tId);
			// valid name : HTTP 200 , marshalled center details
		if (Details!=null)
		return ResponseEntity.ok(Details);
			// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	/*  @GetMapping("/{userName}")
	  public ResponseEntity<?>getUserDetails(@PathVariable String userName) 
	  {
	  System.out.println("in get  details " + userName); 
	  // invoke s  method
	  User Details = service.getUserDetails(userName);
	  //valid name : HTTP 200 , marshalled center details 
	  if (Details!=null)
	  return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }*/
	 
	
	//add
	@CrossOrigin(origins= {"http://localhost:4200"})
	  @PostMapping
	  public ResponseEntity<?> addQuestionsDetails(@RequestBody @Valid Questions p)
	  {
	  System.out.println("in add center " + p); 
	  
	  try { 
		  Questions c =service.addQuestionsDetails(p); 
		  return  ResponseEntity.ok(c);
	  
	  }
	  catch (RuntimeException e) 
	  {
		  e.printStackTrace(); 
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		  }
	  }
	  
	/*@PostMapping("/tests/{testId}/questions")
    public Questions addQuestion(@PathVariable int testId,
    @RequestBody Questions question) throws ResourceNotFoundException {
        return testRepo.findByTestId(testId).map(tests->{
            question.setTest1(tests);
            return ResponseEnity.OK(queRepo.save(question));
        }).orElseGet(() ->ResponseEntity.notFound().build());
	}*/
	@CrossOrigin(origins= {"http://localhost:4200"}) 
	@PostMapping("/{testId}")
	public Questions addQuestion(@PathVariable int testId,
    @RequestBody Questions question) throws ResourceNotFoundException {
     Tests test=testRepo.findByTestId(testId);
     question.setTest1(test);
     queRepo.save(question);
     return question;
}
	@CrossOrigin(origins= {"http://localhost:4200"})
	 @PutMapping("/{qId}") 
	    public ResponseEntity<?> updateQuestionsDetails(@PathVariable int qId, @RequestBody Questions p) 
	 {
	  System.out.println("in update " + qId + " " + p); 
	  try 
	  {
		  Questions updatedDetails = service.updateQuestionsDetails(qId, p); 
		  return  ResponseEntity.ok(updatedDetails); 
		  } 
	  catch (RuntimeException e)
	  { 
		  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	  
	 }
	@CrossOrigin(origins= {"http://localhost:4200"})
	 @DeleteMapping("/{qId}")
	 public String deleteQuestions(@PathVariable int qId)
	 {
		 System.out.println("in delete que"+qId);
		 return service.deleteQuestions(qId);
		 
	 }
}
