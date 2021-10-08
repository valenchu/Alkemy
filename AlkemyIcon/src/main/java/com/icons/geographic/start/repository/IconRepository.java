package com.icons.geographic.start.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.entity.IconGeograficoEntity;

@Repository
public interface IconRepository
    extends JpaRepository<IconGeograficoEntity, Long>, JpaSpecificationExecutor<IconGeograficoEntity>
{

    @Query(value = "SELECT i FROM IconGeograficoEntity i WHERE  i.denominacion LIKE %?1%")
    List<IconGeograficoEntity> search(String deno);

    // Methot search for name data and city
    default List<IconGeograficoEntity> searchFilt(String name, LocalDate data, Set<Long> idCity)
    {
        return findAll((root, query, criBuild) -> {

            List<Predicate> predicate = new ArrayList<Predicate>();

            if (StringUtils.hasLength(name)) {// Verify String no null
                // add to predicate, search by like, with root obtain the name of entity and
                // compare with name the name parameter
                predicate.add(criBuild.like(criBuild.lower(root.get("denominacion")), "%" + name + "%"));
            }
            if (data != null) {// verify data no null
                predicate.add(// add date to predicate, compare date to entity with date to parameter
                    criBuild.equal(root.<LocalDate>get("fechaCreacion"), data));
            }
            if (!CollectionUtils.isEmpty(idCity)) {// Verify collection is not empty
                // Create the join type for join inner table
                Join<IconGeograficoEntity, CiudadPaisEntity> joinTable = root.join("city", JoinType.INNER);
                // The root.join joins the two table entity and return list of city JoinType
                // select type join to use

                Expression<String> cityId = joinTable.get("id");
                predicate.add(cityId.in(idCity));
            }

            // Remove the repeat value
            query.distinct(true);

            return criBuild.and(predicate.toArray(new Predicate[0]));
        });
    }

}
