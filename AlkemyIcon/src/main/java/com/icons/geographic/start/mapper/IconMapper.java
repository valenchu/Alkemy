package com.icons.geographic.start.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.entity.IconGeograficoEntity;

@Component
public class IconMapper {

    private ModelMapper modelMapper;

    @Autowired
    public IconMapper(ModelMapper modelMapper) {
	this.modelMapper = modelMapper;
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
	modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public <T> IconGeograficoEntity dtoToIcon(Object a) {

	IconGeograficoEntity t = modelMapper.map(a, IconGeograficoEntity.class);
	return t;
    }

    /*
     * Lists in Java can be mapped using custom element types.
     * 
     * For example, let's say we want to map a list of User entities to a UserDTO
     * list. To achieve this, we'll call map for each element:
     * 
     * List<UserDTO> dtos = users .stream() .map(user -> modelMapper.map(user,
     * UserDTO.class)) .collect(Collectors.toList()); Of course, with some more
     * work, we could make a general-purpose parameterized method:
     * 
     * <S, T> List<T> mapList(List<S> source, Class<T> targetClass) { return source
     * .stream() .map(element -> modelMapper.map(element, targetClass))
     * .collect(Collectors.toList()); } So, then, we could instead do:
     * 
     * List<UserDTO> userDtoList = mapList(users, UserDTO.class);
     * 
     */
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    public <T> IconGeograficoEntity updateIcon(Long id, IconGeograficoEntity icon, IconDtoEdited icondt) {
	if (icon != null) {
	    String img = "", denominacion = "", histori = "";
	    LocalDate da = null;
	    Float alt = null;
	    if (!icondt.getImg().isEmpty())
		img = icondt.getImg();
	    if (!icondt.getDenominacion().isEmpty())
		denominacion = icondt.getDenominacion();
	    if (!icondt.getFechaCreacion().equals(null) || !icondt.getFechaCreacion().equals(""))
		da = icondt.getFechaCreacion();
	    if (icondt.getAltura() != 0)
		alt = icondt.getAltura();
	    if (!icondt.getHistoria().isEmpty())
		histori = icondt.getHistoria();
	    icon.setAltura(alt);
	    icon.setDenominacion(denominacion);
	    icon.setFechaCreacion(da);
	    icon.setHistoria(histori);
	    icon.setImg(img);
	    icon.setId(id);
	}

	return icon;
    }

}
