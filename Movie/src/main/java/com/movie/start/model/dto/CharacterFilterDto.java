package com.movie.start.model.dto;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterFilterDto {
	
	private String name;

	@Min(value = 0)
	private Integer age;
	
	private Set<Long> id_movie;

}
