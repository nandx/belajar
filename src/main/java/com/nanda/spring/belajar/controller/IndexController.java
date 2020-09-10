package com.nanda.spring.belajar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index() {
//		return "home";
		return "hello/index";
	}

}
