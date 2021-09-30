package com.icons.geographic.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.mapper.ContinenteMapper;
import com.icons.geographic.start.repository.ContinenteRepository;

public interface ContienenteService {

    public List<ContinenteEntity> findAll();

    public ContinenteEntity saveCont(ContinenteDto continenteDto, String img, String nomb);

    public ContinenteEntity updateContinent(Long id, ContinenteDto continenteDto);

    public void deleteContinent(Long id);

}
