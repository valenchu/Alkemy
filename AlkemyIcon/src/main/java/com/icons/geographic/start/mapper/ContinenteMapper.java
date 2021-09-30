package com.icons.geographic.start.mapper;

import java.util.Optional;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;

@Component(value = "continenteMapper")

public class ContinenteMapper {

    private ModelMapper modelMapper;

    @Autowired
    public ContinenteMapper(ModelMapper modelMapper) {
	this.modelMapper = modelMapper;
    }

    public ContinenteEntity dtoToCont(ContinenteDto continenteDto) {
	return modelMapper.map(continenteDto, ContinenteEntity.class);
    }

    public ContinenteEntity guar(ContinenteEntity con, ContinenteDto continenteDto) {
	con.setDenominacion(continenteDto.getDenominacion());
	con.setImg(continenteDto.getImg());
	return con;
    }

}
