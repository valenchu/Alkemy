package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.repository.IconRepository;
import com.icons.geographic.start.service.IconGeoService;

@Service
public class IconGeoImpl implements IconGeoService {

    private final IconRepository iconRepository;

    @Autowired
    public IconGeoImpl(IconRepository iconRepository) {
	this.iconRepository = iconRepository;
    }

    public List<IconGeograficoEntity> getResp() {
	return iconRepository.findAll();

    }

    /*
     * List.of(new Icon(1L,
     * "https://cdn-icons-png.flaticon.com/512/1206/1206798.png", "Marcador",
     * LocalDate.of(1992, 8, 29), 129F, "A icon Wonderful", new CiudadPais(1L,
     * "https://cdn-icons-png.flaticon.com/512/1717/1717547.png", "Francia",
     * 67000000L, 1265468F)));
     */

}
