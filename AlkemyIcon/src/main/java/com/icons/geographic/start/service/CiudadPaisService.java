package com.icons.geographic.start.service;

import java.util.List;

import com.icons.geographic.start.dto.CiudadPaisAndIconDto;
import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;

public interface CiudadPaisService
{

    public List<CiudadPaisCompressDto> getEntity();

    public void deleteCity(Long id);

    public CiudadPaisEntity saveCity(CiudadPaisDto ciudadPaisDto);

    public List<CiudadPaisAndIconDto> getCityAndIcon();

    public void updatePais(CiudadPaisDto ciudadPaisDto, Long id);
}
