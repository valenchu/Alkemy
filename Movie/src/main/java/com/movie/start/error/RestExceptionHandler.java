package com.movie.start.error;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.movie.start.error.response.Response;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// Method return Response
	private ResponseEntity<Object> buildResponseEntity(Response response) {
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exep) {
		Response response = new Response(HttpStatus.NOT_FOUND);
		response.setMessage(exep.getMessage());
		return buildResponseEntity(response);

	}

//@Valid error method!!!
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		Response apiError = new Response(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	@ExceptionHandler(value = { InvalidFileNameException.class })
	public ResponseEntity<Object> handleFileNameNotFound(EntityNotFoundException exep, Throwable e) {
		Response response = new Response(HttpStatus.NO_CONTENT);
		response.setMessage(exep.getMessage());
		response.setMesaggeError(e.getMessage());
		return buildResponseEntity(response);

	}

	@ExceptionHandler(value = { BadCredentialsException.class })
	public ResponseEntity<Object> badCredencial(BadCredentialsException exep, Throwable e) {
		Response response = new Response(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		response.setMessage(exep.getMessage());
		response.setMesaggeError(e.getMessage());
		return buildResponseEntity(response);

	}

	@ExceptionHandler(value = { MesaggeError.class })
	public ResponseEntity<Object> handleBadRequest(MesaggeError exep, WebRequest re) {
		Response response = new Response(HttpStatus.NOT_FOUND, re.toString(), exep.getMessage(), exep);
		return buildResponseEntity(response);

	}

}
