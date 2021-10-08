package com.movie.start.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "`character`")
@SQLDelete(sql = "UPDATE character SET deleted = true WHERE id = ? ")
@Where(clause = "deleted = false")
public class CharacterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idChar;
	private String imagen;
	private String name;
	private Integer age;
	private Float weight;
	private String history;
	private boolean deleted = Boolean.FALSE;
	@ManyToMany(mappedBy = "character", cascade = {CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH})
	private List<MovieEntity> movie = new ArrayList<>();

}
