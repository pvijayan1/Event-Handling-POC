package com.sample.event.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sample.events.UserCreationEvent;
import com.sample.repository.PianoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PianoEventListener {
	
	@Autowired
	PianoRepository pianoRepository;
	
	

	// @Order(1)
	@EventListener
	public void handleEventStart(UserCreationEvent uce) {
		/*log.debug("Thread name in CustomSpringEvent listener---->" + Thread.currentThread().getName());
		log.debug("Piano Listener triggered to User creation event----->");
		log.debug("Piano Listener IDXiD----->" + uce.getUser().getIdxId());
		log.debug("Piano Listener IDXiD----->" + uce.getUser().getBedRockId());
		pianoRepository.saveUserInPiano(uce.getUser());*/
	}
	
	

}
