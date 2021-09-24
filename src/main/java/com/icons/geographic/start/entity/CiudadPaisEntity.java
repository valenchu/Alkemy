package com.icons.geographic.start.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "`ciudad_pais`")
public class CiudadPaisEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ciudad_pais")
	private Long idCiudadPais;
	@Column
	@NotNull
	private String img;
	@Column
	@NotNull
	private String denominacion;
	@Column(name = "cant_habitante")
	@NotNull
	private Long cantHabitante;
	@Column
	@NotNull
	private Double superficie;
	@Column(name = "icon_geografic_aso")
	@NotNull
	private String iconGeograficosAsociado;

}
