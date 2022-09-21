package com.sample.event.publisher;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomSpringEventPublisher {	
//public class CustomSpringEventPublisher implements ApplicationEventPublisherAware{
	
	//private ApplicationEventPublisher publisher;

	
	
	
	/*@Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        log.debug("Publishing custom event by Publisher :) ");
        log.debug("Thread name in publisher---->"+Thread.currentThread().getName());
        final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        String dupMsg = "Sample Message for sec event";
        final SampleEvent sampleEvent = new SampleEvent(this, dupMsg);
        applicationEventPublisher.publishEvent(customSpringEvent);
        applicationEventPublisher.publishEvent(sampleEvent);
       // log.debug("Publishing completed :) ");
    }*/

	/*public void publishCustomEvent(final String message) {
		System.out.println("Publishing custom event. ");
		CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
		applicationEventPublisher.publishEvent(customSpringEvent);
	}*/
	
	/*@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
		
	}*/

}
