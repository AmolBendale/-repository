package com.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.payloads.AdminDTO;
import com.app.repository.AdminRepository;
import com.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ModelMapper model;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AdminDTO createAdmin(AdminDTO admindto) {
		admindto.setPassword(this.passwordEncoder.encode(admindto.getPassword()));
		Admin admin = this.adminRepo.save(this.model.map(admindto, Admin.class));
		return this.model.map(admin, AdminDTO.class);
	}

}
