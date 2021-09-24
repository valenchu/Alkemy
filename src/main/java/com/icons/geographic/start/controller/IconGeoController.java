package com.icons.geographic.start.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ic")
@CrossOrigin("*")
public class IconGeoController {

	@GetMapping
	public String test() {
		return "Todo OK";
	}

}
