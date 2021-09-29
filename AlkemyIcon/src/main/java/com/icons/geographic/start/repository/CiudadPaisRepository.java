package com.icons.geographic.start.repository;

import org.springframework.stereotype.Repository;

import com.icons.geographic.start.entity.CiudadPaisEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CiudadPaisRepository extends JpaRepository<CiudadPaisEntity, Long> {

}
