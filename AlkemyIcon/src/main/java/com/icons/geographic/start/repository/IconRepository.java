package com.icons.geographic.start.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icons.geographic.start.entity.IconGeograficoEntity;

@Repository
public interface IconRepository
	extends JpaRepository<IconGeograficoEntity, Long>, JpaSpecificationExecutor<IconGeograficoEntity> {

    @Query(value = "SELECT i FROM IconGeograficoEntity i WHERE  i.denominacion LIKE %?1%")
    List<IconGeograficoEntity> search( String deno);

    
}
