package com.sample.events;

import com.sample.model.User;

import lombok.Getter;

@Getter
public class UserCreationEvent{
	
	private User user;
	
public UserCreationEvent(User user) {		
		this.user = user;		
	}

}
