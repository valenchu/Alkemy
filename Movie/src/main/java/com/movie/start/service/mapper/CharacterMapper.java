package com.movie.start.service.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.CharacterCompressDto;
import com.movie.start.model.dto.CharacterWithOutMovieDto;
import com.movie.start.model.entity.CharacterEntity;

@Component
public class CharacterMapper {

	private ModelMapper mapper;
	@Autowired
	public CharacterMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public CharacterEntity characterDto2Entity(Object characterDto) {
		return mapper.map(characterDto, CharacterEntity.class);
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> mapper.map(element, targetClass))
				.collect(Collectors.toList());
	}

	public void editCharacter(CharacterEntity character,
			CharacterWithOutMovieDto characterCompress) throws MesaggeError {
		if (character != null && characterCompress != null) {
			if (characterCompress.getAge() != null)
				character.setAge(characterCompress.getAge());
			if (characterCompress.getHistory() != null)
				character.setHistory(characterCompress.getHistory());
			if (characterCompress.getImagen() != null)
				character.setImagen(characterCompress.getImagen());
			if (characterCompress.getName() != null)
				character.setName(characterCompress.getName());
			if (characterCompress.getWeight() != null)
				character.setWeight(characterCompress.getWeight());

		} else {
			throw new MesaggeError("entity null in mapper character"
					+ characterCompress.toString() + " "
					+ character.toString());
		}

	}

	public CharacterWithOutMovieDto characterEntity2characterWitoutDto(
			Object characterEntity) {
		return mapper.map(characterEntity, CharacterWithOutMovieDto.class);
	}
}
