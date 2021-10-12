package com.movie.start.service.implement;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.CharacterCompressDto;
import com.movie.start.model.dto.CharacterFilterDto;
import com.movie.start.model.dto.CharacterWithOutMovieDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.repository.CharacterRepository;
import com.movie.start.repository.specialization.CharacterRepoSpecialization;
import com.movie.start.service.CharacterService;
import com.movie.start.service.mapper.CharacterMapper;

@Service
public class CharacterServiceImplement implements CharacterService {
	// Mapper
	private CharacterMapper characterMapper;
	// Repo
	private CharacterRepository characterRepository;
	private CharacterRepoSpecialization characterRepoSpecialization;

	@Autowired
	public CharacterServiceImplement(CharacterMapper characterMapper, CharacterRepository characterRepository,
			CharacterRepoSpecialization characterRepoSpecialization) {
		this.characterMapper = characterMapper;
		this.characterRepository = characterRepository;
		this.characterRepoSpecialization = characterRepoSpecialization;
	}

	@Override
	public void characterCreate(CharacterWithOutMovieDto characterDto) throws MesaggeError {
		if (!Objects.isNull(characterDto)) {
			CharacterEntity charEnt = characterMapper.characterDto2Entity(characterDto);
			characterRepository.save(charEnt);
			return;
		}
		throw new MesaggeError("Object null character service impl" + characterDto.toString());
	}

	@Override
	public List<CharacterCompressDto> getAllCharacter() throws MesaggeError {
		List<CharacterEntity> charEnt = characterRepository.findAll();
		if (!charEnt.isEmpty()) {
			return characterMapper.mapList(charEnt, CharacterCompressDto.class);
		}
		throw new MesaggeError("Search empty class: character_service_impl" + charEnt.toString());
	}

	@Override
	public List<CharacterEntity> getCharacter() throws MesaggeError {
		try {
			List<CharacterEntity> charEnt = characterRepository.findAll();
			return charEnt;
		} catch (MesaggeError e) {
			throw new MesaggeError("Var charEnt empty or null " + e);
		}
	}

	@Override
	public List<CharacterEntity> getById(Set<Long> idChar) {
		try {
			return characterRepository.findAllById(idChar);
		} catch (Exception e) {
			throw new MesaggeError("Bad search with ID " + idChar + " " + e.getMessage());
		}
	}

	@Override
	public List<CharacterEntity> filter(String name, Integer age, Set<Long> id_movie) throws MesaggeError {
		CharacterFilterDto charaFilter = new CharacterFilterDto();
		charaFilter.setAge(age);
		charaFilter.setId_movie(id_movie);
		charaFilter.setName(name);
		try {
			List<CharacterEntity> charListFilter = characterRepository
					.findAll(characterRepoSpecialization.getByFilters(charaFilter));
			return charListFilter;
		} catch (Exception e) {
			throw new MesaggeError("Error in charListFilter at the time search for filter " + e.getMessage());
		}

	}

	@Override
	public CharacterWithOutMovieDto editCharacter(CharacterWithOutMovieDto compressDto, Long id) {
		CharacterEntity character = characterRepository.findById(id).get();
		characterMapper.editCharacter(character, compressDto);
		CharacterEntity characterSave = this.characterRepository.save(character);

		return compressDto = characterMapper.characterEntity2characterWitoutDto(characterSave);
	}

	@Override
	public void deletedCharacter(Long id) throws MesaggeError {
		if (id != null) {
			characterRepository.deleteById(id);
		}
	}

}
