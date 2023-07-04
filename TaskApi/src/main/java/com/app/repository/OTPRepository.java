package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.OTP;


@Repository
public interface OTPRepository extends JpaRepository<OTP, Long>{

	public Optional<OTP> findFirstByEmailOrderByGeneratedOnDesc(String email);

	public void deleteByEmail(String email);
}
