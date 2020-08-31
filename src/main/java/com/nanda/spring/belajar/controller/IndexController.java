package com.nanda.spring.belajar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@ResponseBody
	@GetMapping("/index")
	public String index() {
		return "helloo belajar";
	}

}
