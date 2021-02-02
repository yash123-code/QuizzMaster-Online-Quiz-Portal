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
import com.app.pojos.Answers;
import com.app.pojos.Questions;
import com.app.repository.AnswersRepository;
import com.app.repository.QuestionRepository;
import com.app.service.IAnswersService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
@RequestMapping("/ans")
public class AnswersController {
@Autowired
private IAnswersService service; 
@Autowired
AnswersRepository dao;
@Autowired
QuestionRepository qdao;

public AnswersController() {
	System.out.println("in ctor of " + getClass().getName());
}

// RESTful end point or API end point or API provider
@CrossOrigin(origins= {"http://localhost:4200"})
@GetMapping
public ResponseEntity<?> listAllAnswers() {
	System.out.println("in list all ");
	// invoke service layer's method : controller --> service impl (p) --->JPA
	// repo's impl class(SC)
	List<Answers> ans = service.getAllAnswers();
	if (ans.isEmpty())
		// empty  list : set sts code : HTTP 204 (no contents)
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// in case of non empty list : OK, send the list
	return  ResponseEntity.ok(ans);  //200 ok
}

// get prduct details by its name : supplied by clnt using path var
@CrossOrigin(origins= {"http://localhost:4200"})
@GetMapping("/{ansId}")
public ResponseEntity<?> getAnswersDetailsByqId(@PathVariable int ansId) {
System.out.println("in get  details " + ansId);
	// invoke service method
Answers Details = service.getAnswersDetailsByansId(ansId);
	// valid name : HTTP 200 , marshalled center details
if (Details!=null)
return ResponseEntity.ok(Details);
	// in case of invalid name : HTTP 404
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@CrossOrigin(origins= {"http://localhost:4200"})
@GetMapping("/queId/{qId}")
public ResponseEntity<?> getQuestionsDetailsBytId(@PathVariable int qId) {
	System.out.println("in get  details " + qId);
		// invoke service method
	List<Answers> answers = service.findByQues(qId);
		// valid name : HTTP 200 , marshalled center details
	if (answers!=null)
	return ResponseEntity.ok(answers);
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
  @PostMapping()
  public ResponseEntity<?> addAnswersDetails(@RequestBody @Valid Answers p)
  {
  System.out.println("in add center " + p); 
  
  try { 
	  Answers c =service.addAnswersDetails(p); 
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
@PostMapping("/{qId}")
public Answers addAnswers(@PathVariable int qId,
@RequestBody Answers answers) throws ResourceNotFoundException {
 Questions ques=qdao.findByqId(qId);
 answers.setQues(ques);
 dao.save(answers);
 return answers;
}
@CrossOrigin(origins= {"http://localhost:4200"})
 @PutMapping("/{ansId}") 
    public ResponseEntity<?> updateAnswersDetails(@PathVariable int ansId, @RequestBody Answers p) 
 {
  System.out.println("in update " + ansId + " " + p); 
  try 
  {
	  Answers updatedDetails = service.updateAnswersDetails(ansId, p); 
	  return  ResponseEntity.ok(updatedDetails); 
	  } 
  catch (RuntimeException e)
  { 
	  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
  }
  
 }
@CrossOrigin(origins= {"http://localhost:4200"})
 @DeleteMapping("/{ansId}")
 public String deleteAnswers(@PathVariable int ansId)
 {
	 System.out.println("in delete que"+ansId);
	 return service.deleteAnswers(ansId);
	 
 }
}


