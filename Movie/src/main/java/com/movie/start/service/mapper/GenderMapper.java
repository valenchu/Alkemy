package com.movie.start.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.model.entity.GenderEntity;

@Component
public class GenderMapper {
	@Autowired
	private ModelMapper mapper;
	
	public GenderEntity genderDto2GenderEntity(GenderCompressDto dto) {
		return mapper.map(dto, GenderEntity.class);
	}

}
