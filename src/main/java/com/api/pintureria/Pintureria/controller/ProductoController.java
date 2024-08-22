package com.api.pintureria.Pintureria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductoController {


	@GetMapping("/hello")
	public String hello() {
	  return "My API is working!";
	}
}
