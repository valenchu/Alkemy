package com.icons.geographic.start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CiudadPaisDto {


	private Long id;
	private String img;
	private String denominacion;
	private Long cantHabitante;
	private Float superficie;// m2
}
