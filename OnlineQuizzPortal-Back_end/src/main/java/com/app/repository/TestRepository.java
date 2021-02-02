package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tests;
@Repository
public interface TestRepository extends JpaRepository<Tests,Integer> {
	Tests findBytestName(String testName);

	 Tests findByTestId(int testId) ;

}
