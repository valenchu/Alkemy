package com.movie.start.service;

import java.util.List;

import com.movie.start.model.dto.CharacterCompressDto;
import com.movie.start.model.dto.CharacterWithOutMovieDto;

public interface CharacterService {

	public void characterCreate(CharacterWithOutMovieDto characterDto);

	public List<CharacterCompressDto> getAllCharacter();

	public CharacterWithOutMovieDto editCharacter(CharacterWithOutMovieDto compressDto,
			Long id);
	public void deletedCharacter(Long id);
}
