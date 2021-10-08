package com.movie.start.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.service.GenderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("gender")
@CrossOrigin("*")
public class GenderController {

	private GenderService genderService;
	@Autowired
	public GenderController(GenderService genderService) {
		this.genderService = genderService;
	}
	@PostMapping("create")
	@Operation(description = "Create a gender in the DB")
	public ResponseEntity<?> createGender(
			@RequestBody(required = false)  GenderCompressDto dto ) {
		
		
		return null;
	}
}
