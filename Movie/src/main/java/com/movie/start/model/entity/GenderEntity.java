package com.movie.start.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "`gender`")
@SQLDelete(sql = "UPDATE gender SET deleted = true WHERE id = ? ")
@Where(clause = "deleted = false")
public class GenderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String imagen;
	private boolean deleted = Boolean.FALSE;
	@OneToOne(mappedBy = "gender")
	private MovieEntity movie;

}
