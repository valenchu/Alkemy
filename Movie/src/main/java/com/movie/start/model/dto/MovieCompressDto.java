package com.movie.start.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCompressDto {

    private String imagen;

    private String title;

    @DateTimeFormat
    private LocalDate dateCreation;
	
	@Size(min = 0,max = 5)
    private Float qualification;
}
