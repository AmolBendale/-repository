package com.app.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="Event_Registration")
public class Event {


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long eventId;
	
	@Column(name="user_Id")
	private long UserId;
	
	@Column(name="created_on",columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;
    
	
	
	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

}
