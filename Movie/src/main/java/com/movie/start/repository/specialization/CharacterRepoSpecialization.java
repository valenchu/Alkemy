package com.movie.start.repository.specialization;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.movie.start.model.dto.CharacterFilterDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.model.entity.MovieEntity;

@Component
public class CharacterRepoSpecialization {

	public Specification<CharacterEntity> getByFilters(CharacterFilterDto filterDto) {
		return (root, query, criBuild) -> {
			List<Predicate> predicate = new ArrayList<>();
			if (StringUtils.hasLength(filterDto.getName())) {// != null

				predicate.add(// add new predicate
						criBuild.like(// search with like
								// with root obtain of bd the name
								criBuild.lower(root.get("name")), filterDto.getName().toLowerCase() + "%"));
			}
			if (filterDto.getAge() != null && filterDto.getAge() > 0) {
				predicate.add(criBuild.equal(root.get("age"), filterDto.getAge()));
			}
			if (!CollectionUtils.isEmpty(filterDto.getId_movie())) {// != null
				Join<CharacterEntity, MovieEntity> joinTable = root.join("movie", JoinType.INNER);
//				Expression<String> movId = joinTable.get("ID_MOV");
				predicate.add(criBuild.like(joinTable.get("idMov").as(String.class),"%"+filterDto.getId_movie()+"%"));

			}

			query.distinct(true);
			return criBuild.and(predicate.toArray(new Predicate[0]));
		};

	}
}
