package com.app.service;

import java.util.List;

import com.app.pojos.Users;

public interface IUserService {

	List<Users> getAllUsers();

	
	Users saveUsers(Users user);
	// get details by first name

	Users getUserDetailsByName(String firstName);

	// get details by Id
	Users getUserDetailsById(int userId);

	// add new details
	Users addUserDetails(Users transientPOJO);

	// update existing details
	Users updateUserDetails(int userId, Users detachedPOJO);

	String deleteUser(int userId);

	Users fetchUserByEmail(String emailId);

	Users fetchUserByEmailIdAndPassword(String emailId, String password);

	Users getUserDetails(String userName);

}
