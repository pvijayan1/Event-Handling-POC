package com.sample.repository;

import org.springframework.stereotype.Component;

import com.sample.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PianoRepository {

	public void saveUserInPiano(User user) {

		//call the Piano backend 
		log.debug("User inserted to Piano");
	}
}
