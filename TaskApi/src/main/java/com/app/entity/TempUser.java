package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "temp")
@Entity
public class TempUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tempUserID;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="phoneNo")
	private long phoneNo;
	
	@Column(name="schoolName")
	private String schoolName;
	
	@Column(name="cityName")
	private String city;
	
	@Column(name="stateName")
	private String state;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public long getTempUserID() {
		return tempUserID;
	}

	public void setTempUserID(long tempUserID) {
		this.tempUserID = tempUserID;
	}

	
}
