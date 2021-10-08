package com.movie.start.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.movie.start.model.entity.CharacterEntity;

@Repository
public interface CharacterRepository
		extends
			JpaRepository<CharacterEntity, Long>,
			JpaSpecificationExecutor<CharacterEntity> {

}
