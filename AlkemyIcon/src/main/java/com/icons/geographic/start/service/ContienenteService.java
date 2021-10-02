package com.icons.geographic.start.service;

import java.util.List;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;

public interface ContienenteService {

    public List<ContinenteDto> findAll();

    public ContinenteEntity saveCont(ContinenteDto continenteDto, String img, String nomb);

    public ContinenteEntity updateContinent(Long id, ContinenteDto continenteDto);

    public void deleteContinent(Long id);

}
