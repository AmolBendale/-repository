package com.app.service;

import com.app.payloads.UserDTO;

public interface UserService {

	public String userExistOrNot(UserDTO userDto);

	public String emailVerification(String email, long otp);
}
