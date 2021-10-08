package com.movie.start.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "`movie_serie`")
@SQLDelete(sql = "UPDATE movie_serie SET deleted = true WHERE id = ? ")
@Where(clause = "deleted = false")
public class MovieEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idMov;
	private String imagen;
	private String title;
	@DateTimeFormat
	@Column(name = "date_creation")
	private LocalDate dateCreation;

	private Float qualification;
	private boolean deleted = Boolean.FALSE;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH})
	@JoinColumn(name = "id")
	private GenderEntity gender;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH})
	@JoinTable(name = "movie_character", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "idMov"), inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "idChar"))
	private List<CharacterEntity> character = new ArrayList<>();
}
