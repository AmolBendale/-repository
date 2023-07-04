package com.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Event;
import com.app.entity.OTP;
import com.app.entity.TempUser;
import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.payloads.UserDTO;
import com.app.repository.EventRepository;
import com.app.repository.TempUserRepository;
import com.app.repository.UserRepository;
import com.app.service.EmailService;
import com.app.service.OTPService;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TempUserRepository tempUserRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OTPService otpservice;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EventRepository eventRepository;

	@Override
	public String userExistOrNot(UserDTO userDto) {

		// user with email not exist in userRegistration so to store in temp
		if (!this.userRepository.existsByEmailId(userDto.getEmailId())) {
			TempUser tempUser = this.modelMapper.map(userDto, TempUser.class);
			this.tempUserRepository.save(tempUser);
		}

		// sending otp on user email
		long otp = this.otpservice.generateOTP();

		if (this.emailService.sendEmail(userDto.getEmailId(), otp)) {
			// store opt to database
			LocalDateTime generatedOn = LocalDateTime.now();
			LocalDateTime expiry = LocalDateTime.now().plusMinutes(30); // otp valid for 30 min from generated time
			String emailId = userDto.getEmailId();
			this.otpservice.saveOTP(new OTP(emailId, otp, expiry, generatedOn));

			return String.format("OTP is sent to given email: %s ", userDto.getEmailId());
		}
		return "OTP sending failed try again";

	}

	@Override
	public String emailVerification(String email, long otp) {

		if (this.otpservice.validateOTP(email, otp)) {

			// for new User

			if (!this.userRepository.existsByEmailId(email)) {
				TempUser tempUser = this.tempUserRepository.findFirstByEmailIdOrderByTempUserIDDesc(email)
						.orElseThrow(() -> new ResourceNotFoundException(email, "TempUser", "Email"));
				User user = this.modelMapper.map(tempUser, User.class);
				user.setUserId(0);
				this.userRepository.save(user);
				this.tempUserRepository.deleteByEmailId(email);
			}

			// Event Registration
			User user = this.userRepository.findByEmailId(email);
			Event event = new Event();
			event.setCreatedOn(LocalDateTime.now());
			event.setUserId(user.getUserId());
			this.eventRepository.save(event);

			return "***** Email is Verified *******";
		}
		return "------- Entered OTP is invalid please try again ! -------";
	}
}
