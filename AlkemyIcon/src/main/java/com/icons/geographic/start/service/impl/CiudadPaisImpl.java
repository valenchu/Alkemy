package com.icons.geographic.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.repository.CiudadPaisRepository;
import com.icons.geographic.start.service.CiudadPaisService;
@Service
public class CiudadPaisImpl implements CiudadPaisService {

    private final CiudadPaisRepository ciudadPaisRepository;

    @Autowired
    public CiudadPaisImpl(CiudadPaisRepository ciudadPaisRepository) {
	this.ciudadPaisRepository = ciudadPaisRepository;
    }

}
