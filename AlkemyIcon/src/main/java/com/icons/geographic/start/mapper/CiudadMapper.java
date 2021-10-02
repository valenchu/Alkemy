package com.icons.geographic.start.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CiudadMapper {

    private ModelMapper modelMapper;

    @Autowired
    public CiudadMapper(ModelMapper modelMapper) {
	this.modelMapper = modelMapper;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}
