package com.icons.geographic.start.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Icon {

	private Long id;
	private String img;
	private String denominacion;
	private LocalDate fechaCreacion;
	private Float altura;
	private String historia;
	private CiudadPais ciudadPais;

}
