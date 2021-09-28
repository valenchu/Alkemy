package com.icons.geographic.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.Icon;
import com.icons.geographic.start.service.IconGeoService;

@RestController
@RequestMapping("ic")
@CrossOrigin("*")
public class IconGeoController {

	private final IconGeoService iconGeoControllerService;

	@Autowired
	public IconGeoController(IconGeoService iconGeoControllerService) {
		this.iconGeoControllerService = iconGeoControllerService;

	}

	@GetMapping
	public List<Icon> test() {
		return iconGeoControllerService.getResp();
	}

}
