package com.app.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userId;
	@Column(name = "username", unique = true, length = 40)
	private String userName;
	@Column(name = "firstname", nullable = false, length = 20)
	private String firstName;
	@Column(name = "lastname", nullable = false, length = 20)
	private String lastName;
	@Column(name = "emailid", unique = true, nullable = false, length = 50)
	private String emailId;
	@Column(name = "password", unique = true, nullable = false, length = 20)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20, nullable = false)
	private Role role;
	@OneToMany(mappedBy = "e3", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ExamDetails> examd3;

	@OneToMany(mappedBy = "us", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<QuestionsResp> qrs;

	public Users() {

	}

	public Users(int userId, String userName, String firstName, String lastName, String emailId, String password,
			Role role, List<ExamDetails> examd3, List<QuestionsResp> qrs) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.examd3 = examd3;
		this.qrs = qrs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ExamDetails> getExamd3() {
		return examd3;
	}

	public void setExamd3(List<ExamDetails> examd3) {
		this.examd3 = examd3;
	}

	public List<QuestionsResp> getQrs() {
		return qrs;
	}

	public void setQrs(List<QuestionsResp> qrs) {
		this.qrs = qrs;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", password=" + password + ", role=" + role + ", examd3=" + examd3
				+ ", qrs=" + qrs + "]";
	}

}