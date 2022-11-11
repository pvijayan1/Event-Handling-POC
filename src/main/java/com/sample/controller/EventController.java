package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.UserRequest;
import com.sample.service.CreateUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RefreshScope
@RequestMapping("/event")
public class EventController {
    
	
	
	@Autowired
    private CreateUserService createUserService;
	
    
    
    
	@PostMapping(value = "/signIn", 
			     consumes = { MediaType.APPLICATION_JSON_VALUE }, 
				 produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postBody(@RequestBody UserRequest userRequest) {
		String str = createUserService.createUser(userRequest);
		return ResponseEntity.ok(str);
	}
}