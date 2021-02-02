package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ExamDetails;
@Repository
public interface ExamDetailsRepository extends JpaRepository<ExamDetails, Integer> {
  ExamDetails findByExamId(int examId);
}
