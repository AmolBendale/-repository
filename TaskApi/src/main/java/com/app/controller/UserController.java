package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.OTP_verificationDTO;
import com.app.payloads.UserDTO;
import com.app.service.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;

	// check user with email exist or not
	// if user not exist store to temp table, send otp to given email
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> userRegistration(@RequestBody UserDTO userDto) {

		String response = this.userservice.userExistOrNot(userDto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Transactional
	@PostMapping("/verify-otp")
	public ResponseEntity<String> email_Verification_With_OTP(@RequestBody OTP_verificationDTO  verifyOtp) {

		String msg=this.userservice.emailVerification(verifyOtp.getEmail(),verifyOtp.getOtp());
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
