package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.CiudadPaisAndIconDto;
import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.error.MesaggeError;
import com.icons.geographic.start.mapper.CiudadMapper;
import com.icons.geographic.start.repository.CiudadPaisRepository;
import com.icons.geographic.start.repository.ContinenteRepository;
import com.icons.geographic.start.service.CiudadPaisService;

@Service
public class CiudadPaisImpl implements CiudadPaisService
{

    private CiudadPaisRepository ciudadPaisRepository;

    private CiudadMapper ciudadMapper;

    @Autowired
    public CiudadPaisImpl(CiudadPaisRepository ciudadPaisRepositor, CiudadMapper ciudadMapper,
        ContinenteRepository continenteRepository)
    {
        this.ciudadPaisRepository = ciudadPaisRepositor;
        this.ciudadMapper = ciudadMapper;
    }

    @Override // Obtains all cities
    public List<CiudadPaisCompressDto> getEntity() throws MesaggeError
    {
        List<CiudadPaisEntity> ciu = ciudadPaisRepository.findAll();
        if (ciu != null) {
            List<CiudadPaisCompressDto> all = ciudadMapper.mapList(ciu, CiudadPaisCompressDto.class);
            if (all != null) {
                return all;
            }
            throw new MesaggeError("Entity Empty to search all" + all);
        }
        throw new MesaggeError("Entity Empty to search ciu" + ciu);
    }

    @Override // Save the city
    public CiudadPaisEntity saveCity(CiudadPaisDto ciudadPaisDto) throws MesaggeError
    {
        CiudadPaisEntity city = ciudadMapper.cityDto2CityEnt(ciudadPaisDto);
        if (city != null) {
            return ciudadPaisRepository.save(city);
        } else {
            throw new MesaggeError("Entity Empty to search city" + city);
        }
    }

    @Override // Obtains all cities with its icons
    public List<CiudadPaisAndIconDto> getCityAndIcon() throws MesaggeError
    {
        List<CiudadPaisEntity> ciudadEntity = ciudadPaisRepository.findAll();
        if (ciudadEntity != null) {

            List<CiudadPaisAndIconDto> ciudadAndIcon = ciudadMapper.mapList(ciudadEntity, CiudadPaisAndIconDto.class);
            if (ciudadAndIcon != null) {
                return ciudadAndIcon;
            }
            throw new MesaggeError("Entity Empty to search ciudadAndIcon" + ciudadAndIcon);
        } else {
            throw new MesaggeError("Entity Empty to search ciudadEntity" + ciudadEntity);
        }
    }

    @Override
    public void updatePais(CiudadPaisDto ciudadPaisDto, Long id) throws MesaggeError
    {

        if (id != 0 && id != null) {
            CiudadPaisEntity ciudadPaisEntity = ciudadPaisRepository.findById(id).get();
            CiudadPaisEntity ciudadPaisEntity2 = ciudadMapper.updateCity(ciudadPaisDto, ciudadPaisEntity);
            ciudadPaisRepository.save(ciudadPaisEntity2);

        } else {
            throw new MesaggeError("Id or ciudadPaisDto null or empty " + id + " " + ciudadPaisDto);
        }
    }

    @Override
    public void deleteCity(Long id) throws MesaggeError
    {
        if (id != 0 && id != null) {
            ciudadPaisRepository.deleteById(id);
        } else {
            throw new MesaggeError("Error to ID id empty or null " + id);
        }

    }

}
