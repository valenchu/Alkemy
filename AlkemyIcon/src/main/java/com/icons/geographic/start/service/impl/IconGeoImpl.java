package com.icons.geographic.start.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.mapper.ContinenteMapper;
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

    public List<IconGeograficoEntity> getResp() {
	return iconRepository.findAll();

    }

    @Override
    public IconGeograficoEntity finAll(IconDto iconDto) {
	IconGeograficoEntity iconn = mapCont.dtoToIcon(iconDto);
	return iconRepository.save(iconn);
    }

    /*
     * List.of(new Icon(1L,
     * "https://cdn-icons-png.flaticon.com/512/1206/1206798.png", "Marcador",
     * LocalDate.of(1992, 8, 29), 129F, "A icon Wonderful", new CiudadPais(1L,
     * "https://cdn-icons-png.flaticon.com/512/1717/1717547.png", "Francia",
     * 67000000L, 1265468F)));
     */

}
