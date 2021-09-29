package com.icons.geographic.start.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
@CrossOrigin("*")
public class Inic {

	@GetMapping
	public String rest() {
		return "Todo OK";
	}
}
