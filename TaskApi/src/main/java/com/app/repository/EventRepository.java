package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

	
}
