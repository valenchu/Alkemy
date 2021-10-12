package com.movie.start.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieListBasicDto {
	private String imagen;
	private String title;
	@DateTimeFormat
	private LocalDate dateCreation;
}
