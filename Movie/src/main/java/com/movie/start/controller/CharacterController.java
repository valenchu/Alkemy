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

import com.movie.start.model.dto.CharacterWithOutMovieDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.service.CharacterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestControllerAdvice
@RequestMapping("character")
@CrossOrigin("*")
@SecurityRequirement(name = "bearer_key")
public class CharacterController {

	private CharacterService characterService;

	@Autowired
	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
	}

	@PostMapping("createCharacter")
	@Operation(summary = "Create a character in BD", description = "{\r\n" + "  \"imagen\": \"string\",\r\n"
			+ "  \"name\": \"string\",\r\n" + "  \"age\": 0,\r\n" + "  \"weight\": 0,\r\n"
			+ "  \"history\": \"string\"\r\n" + "}")
	public ResponseEntity<?> characterCreate(@Valid @RequestBody CharacterWithOutMovieDto characterDto) {
		characterService.characterCreate(characterDto);
		return new ResponseEntity<>("ALL OK Character created", HttpStatus.CREATED);
	}

	@GetMapping("characteres")
	@Operation(summary = "Obtain the characteres of BD")
	public ResponseEntity<?> getAllCharacter() {

		return new ResponseEntity<>(characterService.getAllCharacter(), HttpStatus.OK);
	}

	@GetMapping("characteresAll")
	@Operation(summary = "Obtain the characteres of BD with all details")
	public ResponseEntity<?> getCharacter() {
		return new ResponseEntity<>(characterService.getCharacter(), HttpStatus.OK);
	}

	@GetMapping("findCharacter")
	@Operation(summary = "Filter for name, age and id movie")
	public ResponseEntity<?> filter(
			@Parameter(description = "The name of character") @RequestParam(required = true) String name,
			@Parameter(description = "Age of character") @RequestParam(required = false) Integer age,
			@Parameter(description = "Id movie") @RequestParam(required = false) Set<Long> id_movie) {
		List<CharacterEntity> charFilt = characterService.filter(name, age, id_movie);
		return new ResponseEntity<>(charFilt, HttpStatus.OK);
	}

	@PutMapping("editCharacter")
	@Operation(summary = "Edit the charater for id inserted", description = "Initialize the parameter with null for no edited, only initialize the parameter to edit.\n example {\"name\": \"valueHere\",}")
	public ResponseEntity<?> eidtCharacter(@Valid @RequestBody(required = false) CharacterWithOutMovieDto charDto,
			@Parameter(description = "Insert the id character to modify") @RequestParam Long id) {

		return new ResponseEntity<>(characterService.editCharacter(charDto, id), HttpStatus.OK);
	}

	@DeleteMapping("deleteCharacter/{id}")
	@Operation(summary = "Delete a character to election with id")
	public ResponseEntity<?> deleteCharacter(
			@Parameter(description = "Isert the ID to deleted character") @PathVariable(value = "id") Long id) {
		characterService.deletedCharacter(id);
		return new ResponseEntity<>("Character with id " + id + " deleted", HttpStatus.OK);
	}

}
