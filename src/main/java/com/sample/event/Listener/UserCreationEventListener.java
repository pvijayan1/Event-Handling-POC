package com.sample.event.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sample.events.UserCreationEvent;
import com.sample.repository.PianoRepository;
import com.sample.repository.SailThruRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCreationEventListener {
	
	//multiple tasks(both Piano and SailThru) done by a single listener
	
	@Autowired
	PianoRepository pianoRepository;
	
	@Autowired
	SailThruRepository sailThruRepository;
	
	

	// @Order(1)
	@EventListener
	public void handleUserCreationEvent(UserCreationEvent uce) {
		/*log.debug("Thread name in CustomSpringEvent listener---->" + Thread.currentThread().getName());
		log.debug("UserCreationEventListener triggered to User creation event----->");
		log.debug("UserCreationEventListener IDXId----->" + uce.getUser().getIdxId());
		log.debug("UserCreationEventListener BedRockId----->" + uce.getUser().getBedRockId());
		pianoRepository.saveUserInPiano(uce.getUser());
		sailThruRepository.saveUserInSailThru(uce.getUser());*/
	}
	
	

}
