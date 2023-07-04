package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.AdminRepository;

@Service
public class CustomeUserDetailService implements UserDetailsService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//load user from database
		
		Admin admin=this.adminRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("Admin","Email", username));
		return admin;
	}

}
