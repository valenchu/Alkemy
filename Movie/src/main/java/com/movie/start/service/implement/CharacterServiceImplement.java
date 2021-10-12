package com.movie.start.service.implement;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.CharacterCompressDto;
import com.movie.start.model.dto.CharacterWithOutMovieDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.repository.CharacterRepository;
import com.movie.start.service.CharacterService;
import com.movie.start.service.mapper.CharacterMapper;

@Service
public class CharacterServiceImplement implements CharacterService {

	private CharacterMapper characterMapper;

	private CharacterRepository characterRepository;

	@Autowired
	public CharacterServiceImplement(CharacterMapper characterMapper,
			CharacterRepository characterRepository) {
		this.characterMapper = characterMapper;
		this.characterRepository = characterRepository;
	}

	@Override
	public void characterCreate(CharacterWithOutMovieDto characterDto)
			throws MesaggeError {
		if (!Objects.isNull(characterDto)) {
			CharacterEntity charEnt = characterMapper
					.characterDto2Entity(characterDto);
			characterRepository.save(charEnt);
			return;
		}
		throw new MesaggeError(
				"Object null character service impl" + characterDto.toString());
	}

	@Override
	public List<CharacterCompressDto> getAllCharacter() throws MesaggeError {
		List<CharacterEntity> charEnt = characterRepository.findAll();
		if (!charEnt.isEmpty()) {
			return characterMapper.mapList(charEnt, CharacterCompressDto.class);
		}
		throw new MesaggeError("Search empty class: character_service_impl"
				+ charEnt.toString());
	}

	@Override
	public CharacterWithOutMovieDto editCharacter(
			CharacterWithOutMovieDto compressDto, Long id) {
		CharacterEntity character = characterRepository.findById(id).get();
		characterMapper.editCharacter(character, compressDto);
		CharacterEntity characterSave = this.characterRepository
				.save(character);

		return compressDto = characterMapper
				.characterEntity2characterWitoutDto(characterSave);
	}

	@Override
	public void deletedCharacter(Long id) throws MesaggeError {
		if (id != null) {
			characterRepository.deleteById(id);
		}
	}

}
