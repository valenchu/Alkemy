package com.icons.geographic.start.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.entity.IconGeograficoEntity;

@Component
public class IconMapper {

    private ModelMapper modelMapper;

    @Autowired
    public IconMapper(ModelMapper modelMapper) {
	this.modelMapper = modelMapper;
    }

    public IconGeograficoEntity dtoToIcon(IconDto iconDto) {
	
	return modelMapper.map(iconDto, IconGeograficoEntity.class);
    }

}
