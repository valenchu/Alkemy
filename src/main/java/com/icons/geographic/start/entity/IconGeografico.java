package com.icons.geographic.start.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "`incono_geografico`")
public class IconGeografico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_icono;
	@Column
	@NotNull
	private String img;
	@Column
	@NotNull
	private String denominacion;
	@Column(name = "`fecha_de_creacion`")
	@NotNull
	private LocalTime fechaCreacion;
	@Column
	@NotNull
	private Float altura;
	@Column
	@NotNull
	private String historia;
	@Column(name = "`ciudad_encontrada`")
	@NotNull
	private String ciudadEncontrada;

}
