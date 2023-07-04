package com.app.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.OTP;
import com.app.exception.InvalidOTPException;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.OTPRepository;

@Service
public class OTPService {

	@Autowired
	private OTPRepository otpRepo;

	// method to generate otp
	public long generateOTP() {
		Random rm = new Random();
		long otp = 100000 + rm.nextLong(900000);
		return otp;
	}

	// to validate otp
	public boolean validateOTP(String email, long otp) {
		
		System.out.println(email);
		OTP otpdetails = this.otpRepo.findFirstByEmailOrderByGeneratedOnDesc(email).orElseThrow(()->new InvalidOTPException("OTP is Invalid please try again..!!!"));
		System.out.println(otpdetails.hashCode());
		boolean flag = false;
		if (otpdetails.getOtpcode() == otp && LocalDateTime.now().isBefore(otpdetails.getExpiry())) {
			this.otpRepo.deleteByEmail(email);// removing redundant record from otp
			flag = true;
			return flag;
		} else {
			return flag;
		}
	}

	// store generated otp to OTP table
	public void saveOTP(OTP otp) {
		this.otpRepo.save(otp);
	}
}
