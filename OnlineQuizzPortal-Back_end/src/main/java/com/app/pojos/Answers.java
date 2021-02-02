package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "answers")
public class Answers implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ansid", length = 20)
	int ansId;
	@Column(name = "ans", length = 1500)
	String answer;
	@Column(name = "is_correct")
	Boolean isCorrect;
	@ManyToOne
	@JoinColumn(name = "qid", nullable = false)
	Questions ques;
	public Answers(){
		
	}
	public Answers(int ansId, String answer, Boolean isCorrect, Questions ques) {
		super();
		this.ansId = ansId;
		this.answer = answer;
		this.isCorrect = isCorrect;
		this.ques = ques;
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Questions getQues() {
		return ques;
	}
	public void setQues(Questions ques) {
		this.ques = ques;
	}
	@Override
	public String toString() {
		return "Answers [ansId=" + ansId + ", answer=" + answer + ", isCorrect=" + isCorrect + ", ques=" + ques + "]";
	}
	
	
}
