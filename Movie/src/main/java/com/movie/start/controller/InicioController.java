package com.movie.start.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestControllerAdvice
@RequestMapping
@CrossOrigin("*")
@SecurityRequirement(name = "bearer_key")
public class InicioController {

    @RequestMapping(method = RequestMethod.GET)

    public String welcome() {

	return "<html>" + "<head>" + "<style>" + "h1 {text-align: center;}" + "</style>" + "</head>" + "<body>"

		+ "<h1>" + "Welcome all OK" + "</h1>"

		+ "</body>" + "</html>";
    }

}
