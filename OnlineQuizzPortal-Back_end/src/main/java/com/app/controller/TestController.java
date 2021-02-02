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

import com.app.pojos.Tests;
import com.app.service.ITestService;
@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ITestService service;


	public TestController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping
	public ResponseEntity<?> listAllTests() {
		System.out.println("in list all ");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Tests> test = service.getAllTests();
		if (test.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(test);  //200 ok
	}

	// get prduct details by its name : supplied by clnt using path var
	@GetMapping("/{testId}")
	@CrossOrigin(origins= {"http://localhost:4200"})
	public ResponseEntity<?> getTestsDetailsById(@PathVariable int testId) {
	System.out.println("in get  details " + testId);
		// invoke service method
	Tests Details = service.getTestsDetailsById(testId);
		// valid name : HTTP 200 , marshalled center details
	if (Details!=null)
	return ResponseEntity.ok(Details);
		// in case of invalid name : HTTP 404
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	  @PostMapping("/{testName}")
	  @CrossOrigin(origins= {"http://localhost:4200"})
	  public ResponseEntity<?>getTestsDetails(@PathVariable String testName) 
	  {
	  System.out.println("in get  details " + testName); 
	  // invoke s  method
	  Tests Details = service.getTestsDetails(testName);
	  //valid name : HTTP 200 , marshalled center details 
	  if (Details!=null)
	  return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	 
	
	//add 
	  @CrossOrigin(origins= {"http://localhost:4200"})
	  @PostMapping 
	  public ResponseEntity<?> addTestsDetails(@RequestBody @Valid Tests p)
	  {
	  System.out.println("in add test " + p); 
	  
	  try { 
		  Tests c =service.addTestsDetails(p); 
		  return  ResponseEntity.ok(c);
	  
	  }
	  catch (RuntimeException e) 
	  {
		  e.printStackTrace(); 
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		  }
	  }
	  
	  //update
	 @PutMapping("/{testId}") 
	 @CrossOrigin(origins= {"http://localhost:4200"})
	    public ResponseEntity<?> updateTestsDetails(@PathVariable int testId, @RequestBody Tests p) 
	 {
	  System.out.println("in update " +testId + " " + p); 
	  try 
	  {
		  Tests updatedDetails = service.updateTestsDetails(testId, p); 
		  return  ResponseEntity.ok(updatedDetails); 
		  } 
	  catch (RuntimeException e)
	  { 
		  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	  
	 }
	 //delete
	 @DeleteMapping("/{testId}")
	 @CrossOrigin(origins= {"http://localhost:4200"})
	 public String deleteTest(@PathVariable int testId)
	 {
		 System.out.println("in delete center"+testId);
		 return service.deleteTest(testId);
		 
	 }
	 
}
