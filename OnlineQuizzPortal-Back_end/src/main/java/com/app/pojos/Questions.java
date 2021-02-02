package com.app.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class Questions implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "qid", length = 20)
	private int qId;
	@Column(name = "ques", length = 1500)
	private String que;
	@Column(name = "marks", length = 1200)
	private int marks;

	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference 
	@JoinColumn(name = "testid", nullable = false)
	private Tests test1;
	@OneToMany(mappedBy = "que", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<QuestionsResp> queresp;
	@OneToMany(mappedBy = "ques",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answers>ans;

	public Questions() {

	}

	public Questions(int qId, String que, int marks, Tests test1, List<QuestionsResp> queresp, List<Answers> ans) {
		super();
		this.qId = qId;
		this.que = que;
		this.marks = marks;
		this.test1 = test1;
		this.queresp = queresp;
		this.ans = ans;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Tests getTest1() {
		return test1;
	}

	public void setTest1(Tests test1) {
		this.test1 = test1;
	}

	public List<QuestionsResp> getQueresp() {
		return queresp;
	}

	public void setQueresp(List<QuestionsResp> queresp) {
		this.queresp = queresp;
	}

	public List<Answers> getAns() {
		return ans;
	}

	public void setAns(List<Answers> ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Questions [qId=" + qId + ", que=" + que + ", marks=" + marks + ", test1=" + test1 + ", queresp="
				+ queresp + ", ans=" + ans + "]";
	}
	
}
	