package com.icons.geographic.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icons.geographic.start.entity.ContinenteEntity;
@Repository
public interface ContinenteRepository extends JpaRepository<ContinenteEntity, Long> {
   
}
