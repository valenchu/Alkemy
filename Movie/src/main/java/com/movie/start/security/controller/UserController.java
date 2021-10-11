package com.movie.start.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.movie.start.security.dto.AuthenticationDto;
import com.movie.start.security.dto.AuthenticationResponseDto;
import com.movie.start.security.entity.UserEntity;
import com.movie.start.security.jwtutils.JwtUtils;
import com.movie.start.security.service.UserDetailServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class UserController {
	private JwtUtils jwtUtils;
	private AuthenticationManager authenticationManager;
	private UserDetailServiceImpl userService;
	@Autowired
	public UserController(AuthenticationManager authenticationManager,
			UserDetailServiceImpl userService, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/login")
	@Operation(summary = "Insert the user and password", description = "{\r\n"
			+ "  \"user\": \"user\",\r\n" + "  \"password\": \"password\"\r\n"
			+ "}")
	public ResponseEntity<?> userSave(
			@RequestBody AuthenticationDto authenticationDto)// capture the data
																// user and pass
			throws BadCredentialsException {

		try {
			// Autenticate the username and pass
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationDto.getUser().toString(),
							authenticationDto.getPassword().trim().toString()));

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Username or Password ICORRECT",
					e);
		}
		final UserDetails userDetails = this.userService// Create user details
														// and insert the data
														// for compara
				// with the DB
				.loadUserByUsername(authenticationDto.getUser());

		final String jwt = jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
	}

	@PostMapping("/register")
	@Operation(summary = "Register the user", description = "{\r\n"
			+ "  \"user\": \"string\",\r\n" + "  \"password\": \"string\"\r\n"
			+ "}")
	public ResponseEntity<?> registerUser(
			@RequestBody AuthenticationDto authenticationDto)
			throws BadCredentialsException {
		try {
			UserEntity user = userService.saveUser(authenticationDto);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(
					"Invalid data entry" + e.getMessage());
		}

	}

}
