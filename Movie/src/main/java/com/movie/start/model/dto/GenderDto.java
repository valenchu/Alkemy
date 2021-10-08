package com.movie.start.model.dto;

import com.movie.start.model.entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderDto {
	private String name;
	private String imagen;
	private MovieEntity movie;

}
