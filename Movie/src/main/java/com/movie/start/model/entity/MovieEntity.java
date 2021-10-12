package com.movie.start.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "`movie_serie`")
@SQLDelete(sql = "UPDATE `movie_serie` m SET deleted = true WHERE ID_MOV = ?")
@Where(clause = "deleted = false")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "`id_mov`")
    private Long idMov;
    private String imagen;
    private String title;
    @DateTimeFormat
    @Column(name = "date_creation")
    private LocalDate dateCreation;

    private Float qualification;
    private boolean deleted = Boolean.FALSE;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "movie_gender", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id_mov"), inverseJoinColumns = @JoinColumn(name = "gender_id", referencedColumnName = "id_gender"))
    private List<GenderEntity> gender = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "movie_character", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id_mov"), inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id_char"))
    private List<CharacterEntity> character = new ArrayList<>();
}
