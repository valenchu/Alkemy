package com.movie.start.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.model.entity.GenderEntity;
import com.movie.start.model.entity.MovieEntity;
import com.movie.start.service.GenderService;

@Component
public class MovieMapper {

	private ModelMapper mapper;
	private GenderService genderService;

	@Autowired
	public MovieMapper(ModelMapper mapper, GenderService genderService) {
		this.mapper = mapper;
		this.genderService = genderService;
	}

	public MovieEntity movieDto2MovieEntity(MovieCompressDto dto, Set<Long> id) throws MesaggeError {
		if (id != null && dto != null) {
			List<GenderEntity> genEntity = genderService.getByIdGender(id);
			MovieEntity movieEntity = mapper.map(dto, MovieEntity.class);
			movieEntity.setGender(genEntity);
			return movieEntity;
		}
		throw new MesaggeError("id or dto null");

	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> mapper.map(element, targetClass)).collect(Collectors.toList());
	}

	public void enrrollMovieChar(MovieEntity mEnt, List<CharacterEntity> cEnt) {
		mEnt.setCharacter(cEnt);

	}

	public void refreshEntity(MovieEntity entity, MovieCompressDto entityDto) {
		if (!Objects.isNull(entity) && !Objects.isNull(entityDto)) {
			if (entityDto.getTitle() != null)
				entity.setTitle(entityDto.getTitle());
			if (entityDto.getQualification() != null)
				entity.setQualification(entityDto.getQualification());
			if (entityDto.getImagen() != null)
				entity.setImagen(entityDto.getImagen());
			if (entityDto.getDateCreation() != null)
				entity.setDateCreation(entityDto.getDateCreation());
		} else {
			throw new MesaggeError(
					"Error one entity null or this= " + entity.toString() + " or this= " + entityDto.toString());
		}
	}
	public <T> T movieEntity2Dto(MovieEntity ent,Class<T> targetClass) {
		return mapper.map(ent, targetClass);
	}

}
