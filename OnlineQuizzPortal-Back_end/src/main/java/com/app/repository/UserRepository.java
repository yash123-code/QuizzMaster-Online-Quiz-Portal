package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByFirstName(String firstName);
	
	Users findByUserName(String userName);

	Users findByUserId(int userId);
   //  @Query(value="select emailid, password from users",nativeQuery=true)
	Users findByEmailIdAndPassword(String emailId,String password);

	Users findByEmailId(String emailid);
}