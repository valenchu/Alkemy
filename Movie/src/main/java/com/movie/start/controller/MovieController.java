package com.movie.start.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.model.dto.MovieListBasicDto;
import com.movie.start.model.entity.MovieEntity;
import com.movie.start.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.parameters.*;

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
	@Operation(summary = "Create the movie and enroll with gender id", description = "{\r\n"
			+ "  \"imagen\": \"string\",\r\n" + "  \"title\": \"string\",\r\n"
			+ "  \"dateCreation\": \"2021-10-12\",\r\n" + "  \"qualification\": (Float example 2.0)\r\n" + "}")
	public ResponseEntity<?> createMovWithGender(
			@Valid @Parameter(example = "Qualification example \"qualification\": 0.0 or 1.0 or 2.6 no 1,0 or 2,4") @RequestParam(required = true) Set<Long> id_gender,
			@RequestBody MovieCompressDto movieDto) throws MesaggeError {
		if (!(movieDto.getQualification() >= 0) && !(movieDto.getQualification() <= 5)) {
			throw new MesaggeError("qualification has to be entry => of 5 or <= 0");
		}
		movieService.createMovWithGender(movieDto, id_gender);
		return new ResponseEntity<>("Movie create succesfull", HttpStatus.CREATED);

	}

	@GetMapping("movies")
	@Operation(summary = "I Search the list specific in the exam")
	public ResponseEntity<?> getMovieSpecific() {
		List<MovieListBasicDto> movieBasic = movieService.searchMovieBasic();
		return new ResponseEntity<>(movieBasic, HttpStatus.OK);
	}

	@GetMapping("moviesAll")
	@Operation(summary = "Return all fields of the movie with all information")
	public ResponseEntity<?> getAllInformationToMovie() {
		List<MovieEntity> movie = movieService.getListMovieEntity();
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("movieFilter")
	@Operation(summary = "Filter movie for name,idGender and order ASC or DESC")
	public ResponseEntity<?> filterMovie(
			@Parameter(description = "Name of the movie") @RequestParam(required = true) String name,
			@Parameter(description = "List id or one id of gender the movie, one id for item or error") @RequestParam(required = false) Set<Long> idGender,
			@Parameter(description = "Order of the list ASC or DESC, indicate correctly or it'll give error") @RequestParam(defaultValue = "DESC", required = false) String order) {
		List<MovieEntity> movieEntityFilter = this.movieService.filterMovie(name, idGender, order);

		return new ResponseEntity<>(movieEntityFilter, HttpStatus.OK);
	}

	@PutMapping("enrrollMovToChar")
	@Operation(summary = "Enroll movie id with list character id for conect class")
	public ResponseEntity<?> enrrollMovChar(
			@Parameter(description = "ADD one id > 0") @RequestParam(required = true) Long idMov,
			@Parameter(description = "ADD one number for item and > 0") @RequestParam(required = true) Set<Long> idChar) {
		MovieEntity entity = movieService.enrrollMovChar(idMov, idChar);
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("editMovie")
	@Operation(summary = "Edit the movie for ID", description = "{\r\n" + "  \"imagen\": \"string\",\r\n"
			+ "  \"title\": \"string\",\r\n" + "  \"dateCreation\": \"2021-10-12\",\r\n"
			+ "  \"qualification\": (Float example 2.0)\r\n"
			+ "}\n Clear all the schema and just inicialize one parameter or the parameter only you need edit")
	public ResponseEntity<?> editMovie(
			@Valid @Parameter(description = "ADD id for edit movie > 0") @RequestParam(required = true) Long idMovie,
			@RequestBody(required = false) MovieCompressDto movieDto) {
		MovieCompressDto dtoCompress = movieService.editMovie(movieDto, idMovie);
		return new ResponseEntity<>(dtoCompress, HttpStatus.OK);
	}

	@DeleteMapping("deleteMovie/{id}")
	@Operation(summary = "Deleted the movie for ID")
	public ResponseEntity<?> delete(
			@Parameter(description = "Insert the id > 0 to delete movie of BD") @PathVariable Long id) {
		this.movieService.delete(id);
		return new ResponseEntity<>("MOVIE WIT ID = " + id + " IT WAS DELETED", HttpStatus.OK);

	}
}
