package com.movie.start.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieFilterDto {
	private String name;
	private Set<Long> idGender;
	private String order;

	public boolean isAsc() {
		return order.compareTo("ASC") == 0;
	}

	public boolean isDesc() {
		return order.compareTo("DESC") == 0;
	}
}
