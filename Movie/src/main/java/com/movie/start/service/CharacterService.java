package com.movie.start.service;

import java.util.List;
import java.util.Set;

import com.movie.start.model.dto.CharacterCompressDto;
import com.movie.start.model.dto.CharacterWithOutMovieDto;
import com.movie.start.model.entity.CharacterEntity;

public interface CharacterService {

	public void characterCreate(CharacterWithOutMovieDto characterDto);

	public List<CharacterCompressDto> getAllCharacter();

	public List<CharacterEntity> getCharacter();

	public CharacterWithOutMovieDto editCharacter(CharacterWithOutMovieDto compressDto, Long id);

	public void deletedCharacter(Long id);

	public List<CharacterEntity> filter(String name, Integer age, Set<Long> id_movie);

	public List<CharacterEntity> getById(Set<Long> idChar);
}
