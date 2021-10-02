package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.mapper.CiudadMapper;
import com.icons.geographic.start.repository.CiudadPaisRepository;
import com.icons.geographic.start.service.CiudadPaisService;

@Service
public class CiudadPaisImpl implements CiudadPaisService {

    private CiudadPaisRepository ciudadPaisRepository;
    private CiudadMapper ciudadMapper;

    @Autowired
    public CiudadPaisImpl(CiudadPaisRepository ciudadPaisRepositor, CiudadMapper ciudadMapper) {
	this.ciudadPaisRepository = ciudadPaisRepositor;
	this.ciudadMapper = ciudadMapper;
    }

    @Override
    public List<CiudadPaisCompressDto> getEntity() {
	List<CiudadPaisEntity> ciu = ciudadPaisRepository.findAll();
	List<CiudadPaisCompressDto> all = ciudadMapper.mapList(ciu,CiudadPaisCompressDto.class);
	return all;
    }

    

    

}
