package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

	
	
	@GetMapping
	public String index(@RequestParam(value = "name", defaultValue = "World@fdf.com") String name) {
		log.debug("Hello from here--> {}", name);

		
		try {

			String Password = "fgdgfdfd";
			log.debug("This is password--->" + Password);

			String Email = "World@fdf.com";
			log.debug("email--->" + Email);

			

		} catch (Exception e) {

			log.debug(e.getMessage());
		}
		
		return "Hello " + name;
	}

}