package com.movie.start.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.movie.start.model.entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {

	private String imagen;

	private String name;

	@Min(value = 0)
	private Integer age;

	@Min(value = 0)
	private Float weight;

	private String history;

	private List<MovieEntity> movie = new ArrayList<>();

}
