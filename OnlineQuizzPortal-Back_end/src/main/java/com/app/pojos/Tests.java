package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tests")

public class Tests implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "testid")
	private int testId;
	@Column(name = "testName", length = 60, nullable = false)
	private String testName;
	@Column(name = "testdate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate testDate;
	@Column(name = "testduration")
	private LocalTime testDuration;
	// @ManyToMany
	// private List<Users> user = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "test1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Questions> question;
	@JsonIgnore
	@OneToMany(mappedBy = "e2", cascade = CascadeType.ALL)
	private List<ExamDetails> examd2;
	@JsonIgnore
	@OneToMany(mappedBy = "qrs", cascade = CascadeType.ALL)
	private List<QuestionsResp> queresp;

	public Tests() {

	}

	public Tests(int testId, String testName, LocalDate testDate, LocalTime testDuration, List<Questions> question,
			List<ExamDetails> examd2, List<QuestionsResp> queresp) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testDate = testDate;
		this.testDuration = testDuration;
		this.question = question;
		this.examd2 = examd2;
		this.queresp = queresp;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public List<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(List<Questions> question) {
		this.question = question;
	}

	public List<ExamDetails> getExamd2() {
		return examd2;
	}

	public void setExamd2(List<ExamDetails> examd2) {
		this.examd2 = examd2;
	}

	public List<QuestionsResp> getQueresp() {
		return queresp;
	}

	public void setQueresp(List<QuestionsResp> queresp) {
		this.queresp = queresp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examd2 == null) ? 0 : examd2.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result + ((testDuration == null) ? 0 : testDuration.hashCode());
		result = prime * result + testId;
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tests other = (Tests) obj;
		if (examd2 == null) {
			if (other.examd2 != null)
				return false;
		} else if (!examd2.equals(other.examd2))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		if (testDuration == null) {
			if (other.testDuration != null)
				return false;
		} else if (!testDuration.equals(other.testDuration))
			return false;
		if (testId != other.testId)
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", testName=" + testName + ", testDate=" + testDate + ", testDuration="
				+ testDuration + ", question=" + question + ", examd2=" + examd2 + ", queresp=" + queresp + "]";
	}

}
