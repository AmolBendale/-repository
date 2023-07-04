package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to, long otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("----OTP for Email verification---");
		message.setText(String.format(
				" One time password for email verification is %d  \n \n **********  Valid for 30 min  **********", otp));
		boolean sent = false;
		try {
			mailSender.send(message);
			sent = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sent;
	}

}
