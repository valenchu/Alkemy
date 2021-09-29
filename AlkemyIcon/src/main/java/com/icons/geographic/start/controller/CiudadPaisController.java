package com.icons.geographic.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.service.CiudadPaisService;

@RestController
@RequestMapping("cp")
@CrossOrigin("*")
public class CiudadPaisController {

	private final CiudadPaisService ciudadPaisService;

	@Autowired
	public CiudadPaisController(CiudadPaisService ciudadPaisService) {
		this.ciudadPaisService = ciudadPaisService;
	}

}
