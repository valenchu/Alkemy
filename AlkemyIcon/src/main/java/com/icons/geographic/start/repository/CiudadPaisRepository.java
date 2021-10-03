package com.icons.geographic.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icons.geographic.start.entity.CiudadPaisEntity;

@Repository
public interface CiudadPaisRepository extends JpaRepository<CiudadPaisEntity, Long> {
   

}
