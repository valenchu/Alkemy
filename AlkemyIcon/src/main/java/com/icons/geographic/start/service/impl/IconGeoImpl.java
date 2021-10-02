package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.dto.IconDtoMinimized;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.mapper.IconMapper;
import com.icons.geographic.start.repository.IconRepository;
import com.icons.geographic.start.service.IconGeoService;

@Service
public class IconGeoImpl implements IconGeoService {

    private final IconRepository iconRepository;
    private final IconMapper mapCont;

    @Autowired
    public IconGeoImpl(IconRepository iconRepository, IconMapper mapCont) {
	this.iconRepository = iconRepository;
	this.mapCont = mapCont;
    }

    public List<IconDtoMinimized> getResp() {
	List<IconGeograficoEntity> listIcon = iconRepository.findAll();
	List<IconDtoMinimized> minimized = mapCont.mapList(listIcon, IconDtoMinimized.class);
	return minimized;

    }

    @Override
    public <T> IconGeograficoEntity updateIcon(IconDtoEdited iconDto, Long id) {
	IconGeograficoEntity iconUnic = iconRepository.findById(id).get();
	IconGeograficoEntity iU = mapCont.updateIcon(id, iconUnic, iconDto);
	iconUnic = iU;
	System.out.println(iconUnic.toString());
	return iconRepository.save(iconUnic);
    }

    @Override
    public <T> IconGeograficoEntity finAll(Object a) {
	IconGeograficoEntity s = mapCont.dtoToIcon(a);
	return iconRepository.save(s);
    }

    @Override
    public void deleted(Long id) {
	iconRepository.deleteById(id);
    }

    @Override
    public List<IconDto> getRespMax() {
	List<IconGeograficoEntity> listIcon = iconRepository.findAll();
	List<IconDto> minimized = mapCont.mapList(listIcon, IconDto.class);
	return minimized;
    }

    @Override
    public List<IconGeograficoEntity> getEntity() {

	return iconRepository.findAll();
    }

}
