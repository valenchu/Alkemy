package com.movie.start.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SQLDelete(sql = "UPDATE `character` c SET deleted = true WHERE ID_CHAR = ? ")
@Where(clause = "deleted = false")
@Table(name = "`character`")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_char")
    private Long idChar;
    private String imagen;
    private String name;
    private Integer age;
    private Float weight;
    private String history;
    private boolean deleted = Boolean.FALSE;
    @JsonBackReference
    @ManyToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<MovieEntity> movie = new ArrayList<>();

}
