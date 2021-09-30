package com.icons.geographic.start.mapper;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;

public class ContinenteMapper {

    ModelMapper modelMapper = new ModelMapper();

    public ContinenteEntity dtoToCont(ContinenteDto continenteDto) {
	return modelMapper.map(continenteDto, ContinenteEntity.class);
    }
    
    public ContinenteEntity guar(ContinenteEntity continenteEntity, ContinenteDto continenteDto) {
	
	return modelMapper.map(continenteDto, continenteEntity.getClass());
	
    }

}
