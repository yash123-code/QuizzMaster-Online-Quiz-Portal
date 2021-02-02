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

import com.app.pojos.Users;
import com.app.service.IUserService;

@RestController // => @Controller at class level +
// @ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
@RequestMapping("/user")
public class UserController {
	// dependency
	@Autowired
	private IUserService service;


	public UserController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping

	public ResponseEntity<?> listAllUser() {
		System.out.println("in list all ");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Users> User = service.getAllUsers();
		if (User.isEmpty())
			// empty list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return ResponseEntity.ok(User); // 200 ok
	}

	// get prduct details by its name : supplied by clnt using path var
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{userId}")
	
	public ResponseEntity<?> getUserDetailsById(@PathVariable int UserID) {
		System.out.println("in get  details " + UserID);
		// invoke service method
		Users Details = service.getUserDetailsById(UserID);
		// valid name : HTTP 200 , marshalled center details
		if (Details != null)
			return ResponseEntity.ok(Details);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{userName}")
	public ResponseEntity<?> getUserDetails(@PathVariable String userName) {
		System.out.println("in get  details " + userName);
		// invoke s method
		Users Details = service.getUserDetails(userName);
		// valid name : HTTP 200 , marshalled center details
		if (Details != null)
			return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registeruser")
	public Users registerUser(@RequestBody Users user) throws Exception {
		String tempEmail = user.getEmailId();
		if (tempEmail != null && "".equals(tempEmail)) {
			Users userobj = service.fetchUserByEmail(tempEmail);
			if (userobj != null) {
				throw new Exception("User this id " + tempEmail + "is already exist");
			}

		}
		Users userobj = null;
		userobj = service.saveUsers(user);
		return userobj;

	}
//	@PostMapping("/registeru")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ResponseEntity<?> addUsers(@RequestBody Users c) {
//		System.out.println("in add customer " + c);
//		try {
//			Users saveUser = service.saveUsers(c);
//			return new ResponseEntity<>(saveUser, HttpStatus.OK);

//		} catch (RuntimeException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	
	public Users loginUser(@RequestBody Users user) throws Exception {
		String emailId = user.getEmailId();
		String password = user.getPassword();
      
		Users userobj = null;
		
		if (emailId != null && password != null) {
	    System.out.println("email="+emailId+"pass="+password);
			userobj = service.fetchUserByEmailIdAndPassword(emailId, password);
			}
		if (userobj == null) {
			throw new Exception("Bad crendetial");
		}
		return userobj;
	}

	// add
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> addUserDetails(@RequestBody @Valid Users p) {
		System.out.println("in add center " + p);

		try {
			Users c = service.addUserDetails(p);
			return ResponseEntity.ok(c);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// update
	@PutMapping("/{userId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> updateUserDetails(@PathVariable int userId, @RequestBody Users p) {
		System.out.println("in update " + userId + " " + p);
		try {
			Users updatedDetails = service.updateUserDetails(userId, p);
			return ResponseEntity.ok(updatedDetails);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// delete
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{userId}")
	
	public String deleteUsers(@PathVariable int userId) {
		System.out.println("in delete center" + userId);
		return service.deleteUser(userId);

	}

}
