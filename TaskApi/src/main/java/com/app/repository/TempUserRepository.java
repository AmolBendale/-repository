package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.TempUser;

@Repository
public interface TempUserRepository extends JpaRepository<TempUser, Integer>{

	public Optional<TempUser> findFirstByEmailIdOrderByTempUserIDDesc(String email);
	public void deleteByEmailId(String email);
}
