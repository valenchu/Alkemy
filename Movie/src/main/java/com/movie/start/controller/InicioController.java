package com.movie.start.controller;

import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;
import org.springframework.security.config.web.servlet.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestControllerAdvice
@RequestMapping
@CrossOrigin("*")
@SecurityRequirement(name = "bearer_key")
public class InicioController {

	@RequestMapping(method = RequestMethod.GET)
	
	public String welcome() {

		return "<html>" + "<head>" + "<style>" + "h1 {text-align: center;}"
				+ "</style>" + "</head>" + "<body>"

				+ "<h1>" + "Welcome all OK" + "</h1>"

				+ "</body>" + "</html>";
	}

}
