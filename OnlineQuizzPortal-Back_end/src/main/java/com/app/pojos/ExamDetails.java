package com.app.pojos;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "examdetails")

public class ExamDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examid")
	private int examId;
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	// @JsonIgnore
	private Users e3;
	@ManyToOne
	@JoinColumn(name = "testid", nullable = false)
	// @JsonIgnore
	private Tests e2;
	@Column(name = "totalque", length = 20)
	private int TotalQue;
	@Column(name = "totalmarks", length = 20)
	private int TotalMarks;
	
	public ExamDetails() {
	}

	public ExamDetails(int examId, Users e3, Tests e2, int totalQue, int totalMarks) {
		super();
		this.examId = examId;
		this.e3 = e3;
		this.e2 = e2;
		TotalQue = totalQue;
		TotalMarks = totalMarks;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public Users getE3() {
		return e3;
	}

	public void setE3(Users e3) {
		this.e3 = e3;
	}

	public Tests getE2() {
		return e2;
	}

	public void setE2(Tests e2) {
		this.e2 = e2;
	}

	public int getTotalQue() {
		return TotalQue;
	}

	public void setTotalQue(int totalQue) {
		TotalQue = totalQue;
	}

	public int getTotalMarks() {
		return TotalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		TotalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "ExamDetails [examId=" + examId + ", e3=" + e3 + ", e2=" + e2 + ", TotalQue=" + TotalQue
				+ ", TotalMarks=" + TotalMarks + "]";
	}
	
}
