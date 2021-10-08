package com.icons.geographic.start.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.icons.geographic.start.dto.CiudadFilterDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.error.MesaggeError;

@Repository
public interface CiudadPaisRepository
		extends
			JpaRepository<CiudadPaisEntity, Long>,
			JpaSpecificationExecutor<CiudadPaisEntity> {

	default List<CiudadPaisEntity> getFilterCities(CiudadFilterDto cityFilter) {
		return findAll((root, query, cb) -> {

			List<Predicate> predicate = new ArrayList<Predicate>();
			if (StringUtils.hasLength(cityFilter.getName())) {
				predicate.add(cb.like(cb.lower(root.get("denominacion")),
						"%" + cityFilter.getName().toLowerCase() + "%"));
			}
			if (!CollectionUtils.isEmpty(cityFilter.getIdCont())) {

				Join<CiudadPaisEntity, IconGeograficoEntity> joinTable = root
						.join("continente", JoinType.INNER);
				Expression<String> idCon = joinTable.get("id");
				predicate.add(idCon.in(cityFilter.getIdCont()));

			}
			query.distinct(true);
			String orderBy = "denominacion";
			query.orderBy(cityFilter.isDESC()
					? cb.asc(root.get(orderBy))
					: cb.desc(root.get(orderBy)));
			return cb.and(predicate.toArray(new Predicate[0]));
		});
	}

}
