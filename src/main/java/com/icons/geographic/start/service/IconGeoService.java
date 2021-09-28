package com.icons.geographic.start.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.CiudadPais;
import com.icons.geographic.start.dto.Icon;

@Service
public class IconGeoService {

	public List<Icon> getResp() {
		return List.of(new Icon(1L, "https://cdn-icons-png.flaticon.com/512/1206/1206798.png", "Marcador",
				LocalDate.of(1992, 8, 29), 129F, "A icon Wonderful", new CiudadPais(1L,
						"https://cdn-icons-png.flaticon.com/512/1717/1717547.png", "Francia", 67000000L, 1265468F)));
	}

}
