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
@Table(name = "`continente`")
public class ContinenteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_continente")
	private Long idContinente;
	@Column
	@NotNull
	private String img;
	@Column
	@NotNull
	private String denominacion;
	@Column(name = "ciudades_icon_geo")
	@NotNull
	private String ciudadesIconGeo;

}
