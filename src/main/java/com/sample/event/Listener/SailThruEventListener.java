package com.sample.event.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sample.events.UserCreationEvent;
import com.sample.repository.SailThruRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SailThruEventListener {
	
	@Autowired
	SailThruRepository sailThruRepository;
	
	

	// @Order(1)
	@EventListener
	public void handleEventStart(UserCreationEvent uce) {
		/*log.debug("Thread name in SailThru listener---->" + Thread.currentThread().getName());
		log.debug("SailThru Listener triggered to User creation event----->");
		log.debug("SailThru Listener IDXiD----->" + uce.getUser().getIdxId());
		log.debug("SailThru Listener IDXiD----->" + uce.getUser().getBedRockId());
		sailThruRepository.saveUserInSailThru(uce.getUser());*/
	}
	
	

}
