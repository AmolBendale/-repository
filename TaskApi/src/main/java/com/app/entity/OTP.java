package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "one_time_passwords")
public class OTP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otpId;

	@Column(name = "email")
	private String email;

	@Column(name = "one_time_password")
	private long otpcode;

	@Column(name = "Expiration_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime expiry;

	@Column(name = "Generated_On", columnDefinition = "TIMESTAMP")
	private LocalDateTime generatedOn;

	public OTP(String email, long otpcode, LocalDateTime expiry,LocalDateTime generatedOn) {
		this.email = email;
		this.otpcode = otpcode;
		this.expiry = expiry;
		this.generatedOn=generatedOn;
	}

	public OTP() {
		super();
	}

	public LocalDateTime getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(LocalDateTime generatedOn) {
		this.generatedOn = generatedOn;
	}

	public long getOtpId() {
		return otpId;
	}

	public void setOtpId(long otpId) {
		this.otpId = otpId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getOtpcode() {
		return otpcode;
	}

	public void setOtpcode(long otpcode) {
		this.otpcode = otpcode;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

}
