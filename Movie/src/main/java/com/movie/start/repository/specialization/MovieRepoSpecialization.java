package com.movie.start.repository.specialization;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.movie.start.model.dto.MovieFilterDto;
import com.movie.start.model.entity.GenderEntity;
import com.movie.start.model.entity.MovieEntity;

@Component
public class MovieRepoSpecialization {
	public Specification<MovieEntity> getByFilter(MovieFilterDto filterDto) {
		return (root, query, criBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.hasLength(filterDto.getName())) {
				predicates.add(
						criBuilder.like(criBuilder.lower(root.get("title")), filterDto.getName().toLowerCase() + "%"));
			}
			if (!CollectionUtils.isEmpty(filterDto.getIdGender())) {
				Join<MovieEntity, GenderEntity> joinTable = root.join("gender", JoinType.INNER);
				Expression<String> idGender = joinTable.get("id_gender");
				predicates.add(idGender.in(filterDto.getIdGender()));
			}
			String orderBy = "dateCreation";
			query.orderBy(filterDto.isDesc() ? criBuilder.asc(root.get(orderBy)) : criBuilder.desc(root.get(orderBy)));
			return criBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
