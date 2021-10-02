package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.mapper.ContinenteMapper;
import com.icons.geographic.start.repository.ContinenteRepository;
import com.icons.geographic.start.service.ContienenteService;

@Service
public class ContienenteImpl implements ContienenteService {

    private final ContinenteRepository continenteRepository;
    private final ContinenteMapper mapCont;

    @Autowired
    public ContienenteImpl(ContinenteRepository continenteRepository, ContinenteMapper mapCont) {
	this.continenteRepository = continenteRepository;
	this.mapCont = mapCont;
    }

    // save img and name of continent
    public ContinenteEntity saveCont(ContinenteDto continenteDto, String img, String nomb) {

	continenteDto.setImg(img);
	continenteDto.setDenominacion(nomb);
	ContinenteEntity con = mapCont.dtoToCont(continenteDto);
	return continenteRepository.save(con);
    }

    // get all continent in the DB
    public List<ContinenteDto> findAll() {
	List<ContinenteEntity> i = continenteRepository.findAll();
	List <ContinenteDto> cdto = mapCont.mapList(i, ContinenteDto.class);
	return  cdto;
    }

    // update continent for id
    public ContinenteEntity updateContinent(Long id, ContinenteDto continenteDto) {
	ContinenteEntity con = continenteRepository.findById(id).get();
	con = mapCont.guar(con, continenteDto);
	return continenteRepository.save(con);
    }

    // delete continent for id
    public void deleteContinent(Long id) {
	ContinenteEntity con = continenteRepository.findById(id).get();
	continenteRepository.delete(con);
    }

}
