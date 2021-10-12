package com.movie.start.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.model.entity.GenderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private String imagen;
	private String title;
	@DateTimeFormat
	private LocalDate dateCreation;
	private Float qualification;
	private List<GenderEntity> gender;
	private List<CharacterEntity> character = new ArrayList<>();

}
