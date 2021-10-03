package com.icons.geographic.start.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.repository.ContinenteRepository;

@Component
public class CiudadMapper {

    private ModelMapper modelMapper;
    private ContinenteRepository repoContinente;

    @Autowired
    public CiudadMapper(ModelMapper modelMapper, ContinenteRepository repoContinente) {
	this.modelMapper = modelMapper;
	this.repoContinente = repoContinente;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    public CiudadPaisEntity cityDto2CityEnt(CiudadPaisDto ciudadPaisDto) {
	CiudadPaisEntity city = modelMapper.map(ciudadPaisDto, CiudadPaisEntity.class);
	return city;
    }

}
