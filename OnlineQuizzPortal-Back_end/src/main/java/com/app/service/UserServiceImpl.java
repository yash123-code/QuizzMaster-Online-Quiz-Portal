package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Users;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository dao;

	@Override
	public List<Users> getAllUsers() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Users getUserDetailsByName(String firstName) {

		return dao.findByFirstName(firstName);
	}

	@Override
	public Users getUserDetailsById(int userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public Users addUserDetails(Users transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Users updateUserDetails(int userId, Users p1) {

		Users p = dao.findByUserId(userId);
		if (p != null) {
			// p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by
			// clnt
			// change state of persistent POJO
			Users user = p;
			user.setUserName(p1.getUserName());
			user.setFirstName(p1.getFirstName());
			user.setLastName(p1.getLastName());
			user.setEmailId(p1.getEmailId());
			user.setPassword(p1.getPassword());
			user.setRole(p1.getRole());

			return user;

		}

		// in case of no Manager found : throw custom exception
		throw new ResourceNotFoundException("Invalid UserID");

	}

	@Override
	public String deleteUser(int userId) {
		dao.deleteById(userId);
		return "User with ID=" + userId + " is now deleted.";
	}

	@Override
	public Users fetchUserByEmail(String emailId) {
		return dao.findByEmailId(emailId);
	}

	@Override
	public Users fetchUserByEmailIdAndPassword(String emailId, String password) {
		return dao.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public Users saveUsers(Users user) {
		 return dao.save(user);
	}

	@Override
	public Users getUserDetails(String userName) {
		return dao.findByUserName(userName);
	}

}
