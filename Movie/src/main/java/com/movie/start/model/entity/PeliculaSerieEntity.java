package com.movie.start.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pelicula_serie")
public class PeliculaSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String título;
    @DateTimeFormat
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private Float calificación;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private GeneroEntity generoEntity;
}
