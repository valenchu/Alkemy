package com.icons.geographic.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.repository.CiudadPaisRepository;

@Service
public class CiudadPaisService {

	private final CiudadPaisRepository ciudadPaisRepository;

	@Autowired
	public CiudadPaisService(CiudadPaisRepository ciudadPaisRepository) {
		this.ciudadPaisRepository = ciudadPaisRepository;
	}
	
	
}
