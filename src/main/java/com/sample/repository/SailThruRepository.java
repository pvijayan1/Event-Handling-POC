package com.sample.repository;

import org.springframework.stereotype.Component;

import com.sample.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SailThruRepository {

	public void saveUserInSailThru(User user) {

		//call the sail thru backend 		
		log.debug("User inserted to Sailthru");
	}
}
