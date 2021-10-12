package com.movie.start.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.service.MovieService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestControllerAdvice
@RequestMapping("movie")
@CrossOrigin("*")
@SecurityRequirement(name = "bearer_key")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@PostMapping("create_mov_gender")
	public ResponseEntity<?> createMovWithGender(
			@RequestParam(required = true) Set<Long> id_gender,
			@RequestBody MovieCompressDto movieDto) throws MesaggeError{
		if(!(movieDto.getQualification()>=0) || !(movieDto.getQualification()<=5) ) {
			throw new MesaggeError("qualification > of 5 or < 0");
		}
		movieService.createMovWithGender(movieDto, id_gender);
		return new ResponseEntity<>("Movie create succesfull",
				HttpStatus.CREATED);

	}
}
