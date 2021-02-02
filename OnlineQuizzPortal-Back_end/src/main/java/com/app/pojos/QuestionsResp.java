package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QueResp")
public class QuestionsResp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qrid")
	private int QRId;
	@Column(name = "ans", length = 100,nullable=true)
	private String ans;
	@Column(name = "respdate")
	private LocalDate respDate;

	@ManyToOne
	@JoinColumn(name = "qid", nullable = false)
	// @JsonIgnore
	private Questions que;
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	// @JsonIgnore
	private Users us;
	@ManyToOne
	@JoinColumn(name="testid",nullable=false)
	private Tests qrs;

	public QuestionsResp() {

	}

	public QuestionsResp(int qRId, String ans, LocalDate respDate, Questions que, Users us, Tests qrs) {
		super();
		QRId = qRId;
		this.ans = ans;
		this.respDate = respDate;
		this.que = que;
		this.us = us;
		this.qrs = qrs;
	}

	public int getQRId() {
		return QRId;
	}

	public void setQRId(int qRId) {
		QRId = qRId;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public LocalDate getRespDate() {
		return respDate;
	}

	public void setRespDate(LocalDate respDate) {
		this.respDate = respDate;
	}

	public Questions getQue() {
		return que;
	}

	public void setQue(Questions que) {
		this.que = que;
	}

	public Users getUs() {
		return us;
	}

	public void setUs(Users us) {
		this.us = us;
	}

	public Tests getQrs() {
		return qrs;
	}

	public void setQrs(Tests qrs) {
		this.qrs = qrs;
	}

	@Override
	public String toString() {
		return "QuestionsResp [QRId=" + QRId + ",Ans=" + ans + ", respDate=" + respDate + ", que=" + que + ", us=" + us
				+ ", qrs=" + qrs + "]";
	}
    
	}