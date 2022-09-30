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
public class UserCreationEventListenerType2 {
	
	//One class with multiple listeners
	
	@Autowired
	PianoRepository pianoRepository;
	
	@Autowired
	SailThruRepository sailThruRepository;
	
	

	// @Order(1)
	@EventListener
	public void handleEventPianoStart(UserCreationEvent uce) {
		log.debug("Type2 Thread name in Piano listener---->" + Thread.currentThread().getName());
		log.debug("Type2 Piano Listener triggered to User creation event----->");
		log.debug("Type2 Piano Listener IDXiD----->" + uce.getUser().getIdxId());
		log.debug("Type2 Piano Listener IDXiD----->" + uce.getUser().getBedRockId());
		pianoRepository.saveUserInPiano(uce.getUser());
	}
	
	@EventListener
	public void handleEventSailThruStart(UserCreationEvent uce) {
		log.debug("Type2 Thread name in SailThru listener---->" + Thread.currentThread().getName());
		log.debug("Type2 SailThru Listener triggered to User creation event----->");
		log.debug("Type2 SailThru Listener IDXiD----->" + uce.getUser().getIdxId());
		log.debug("Type2 SailThru Listener IDXiD----->" + uce.getUser().getBedRockId());
		sailThruRepository.saveUserInSailThru(uce.getUser());
	}

}
