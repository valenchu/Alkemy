package com.movie.start.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterWithOutMovieDto {

    private String imagen;
    private String name;
	@Min(value = 0)
    private Integer age;
	@Min(value = 0)
    private Float weight;
    private String history;

}
