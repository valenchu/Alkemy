package com.icons.geographic.start.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	if (continenteDto.getDenominacion().isEmpty()) {
	    con.setImg(continenteDto.getImg());
	} else if (continenteDto.getImg().isEmpty()) {
	    con.setDenominacion(continenteDto.getDenominacion());
	} else if (continenteDto.getDenominacion().isEmpty() && continenteDto.getImg().isEmpty()) {
	    con = null;
	}

	return con;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

}
