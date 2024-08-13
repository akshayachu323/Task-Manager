package com.project.taskmanger.controler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {

	@GetMapping("/")
	public String hello() {
		return "welcome to my page";
	}
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}
	
}
