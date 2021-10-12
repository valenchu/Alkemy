package com.movie.start.service.mapper;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.MovieCompressDto;
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

	public MovieEntity movieDto2MovieEntity(MovieCompressDto dto, Set<Long> id)
			throws MesaggeError {
		if (id != null && dto != null) {
			List<GenderEntity> genEntity = genderService.getByIdGender(id);
			MovieEntity movieEntity = mapper.map(dto, MovieEntity.class);
			movieEntity.setGender(genEntity);
			return movieEntity;
		}
		throw new MesaggeError("id or dto null");

	}

}
