package com.movie.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.service.GenderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("gender")
@CrossOrigin("*")
@SecurityRequirement(name = "bearer_key")
public class GenderController {

	private GenderService genderService;
	@Autowired
	public GenderController(GenderService genderService) {
		this.genderService = genderService;
	}

	@PostMapping("create")
	@Operation(description = "{\r\n" + "  \"name\": \"string\",\r\n"
			+ "  \"imagen\": \"string\"\r\n"
			+ "}", summary = "Create gender in DB")
	public ResponseEntity<?> createGender(
			@RequestBody(required = false) GenderCompressDto dto) {
		
		return new ResponseEntity<>(genderService.createGender(dto),HttpStatus.OK);
	}
}
