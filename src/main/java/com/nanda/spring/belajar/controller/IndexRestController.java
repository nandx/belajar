package com.nanda.spring.belajar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {

	@RequestMapping(value = "/rest/index", method = RequestMethod.GET)
	public ResponseEntity<String> restIndex() {
		return new ResponseEntity<String>("ini rest", HttpStatus.OK);
	}
	
	
	

}
