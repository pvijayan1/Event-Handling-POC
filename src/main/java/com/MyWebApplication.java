package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.Util.RegistrationUtil;
import com.sample.config.GlobalProperties;
import com.sample.model.Partner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MyWebApplication {
	
	@Autowired
	private static ApplicationContext context;    
	private static GlobalProperties globalProperties;
	private static HashMap<String, Partner> partnerMap = new HashMap<String, Partner>();
	
   

	public static void main(String[] args) {
		context = SpringApplication.run(MyWebApplication.class, args);		
		/*CustomSpringEventPublisher customSpringEventPublisher =  context.getBean(CustomSpringEventPublisher.class);
		customSpringEventPublisher.publishCustomEvent("Custom Event is published from container!!!!");
		log.debug("Publishing completed :) ");*/
		globalProperties = (GlobalProperties)context.getBean("globalProperties");
		if(null==globalProperties) {
			log.debug("Properties not loaded!!");
		}else {
			log.info("loaded!!");
			log.info("Properties1---->"+globalProperties.getProperties1().toString());
			log.info("Properties2---->"+globalProperties.getProperties2().toString());			
			RegistrationUtil.loadPartnerTemplateIntoMap(partnerMap);
			log.info("partnerMap size in main--->" + partnerMap.size());
		}
	}

	public static Map<String, Map<String, String>> getProperties1(){				
		return globalProperties.getProperties1();
	}
	
	public static Map<String, Map<String, String>> getProperties2(){		
		return globalProperties.getProperties2();
	}


	public static HashMap<String, Partner> getPartnerMap() {
		return partnerMap;
	}
	
	
    

}