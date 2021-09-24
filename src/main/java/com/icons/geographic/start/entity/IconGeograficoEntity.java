package com.icons.geographic.start.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "`incono_geografico`")
public class IconGeograficoEntity {
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
	@DateTimeFormat
	private LocalDateTime  fechaCreacion;
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
