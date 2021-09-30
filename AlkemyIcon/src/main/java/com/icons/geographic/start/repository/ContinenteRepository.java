package com.icons.geographic.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icons.geographic.start.entity.ContinenteEntity;

@Repository
public interface ContinenteRepository extends JpaRepository<ContinenteEntity, Long> {
   

}
