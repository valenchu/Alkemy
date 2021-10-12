package com.movie.start.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	@NotNull
	@Email(message = "Emai invalid, Example mail data@data.com")
	private String userEmail;
	@NotNull
	@Size(min = 6,message = "Pass higher than 8")
	private String password;

}
