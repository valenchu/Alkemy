package com.movie.start.model.dto;

import java.util.ArrayList;
import java.util.List;

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
	private Integer age;
	private Float weight;
	private String history;
	private List<MovieEntity> movie = new ArrayList<>();

}
