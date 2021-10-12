package com.movie.start.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterWithOutMovieDto {
	private String imagen;
	private String name;
	private Integer age;
	private Float weight;
	private String history;

}
