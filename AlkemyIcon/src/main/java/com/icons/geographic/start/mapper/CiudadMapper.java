package com.icons.geographic.start.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.service.ContinenteService;

@Component
public class CiudadMapper
{

    private ModelMapper modelMapper;

    private ContinenteService continenteService;

    @Autowired
    public CiudadMapper(ModelMapper modelMapper, ContinenteService continenteService)
    {
        this.modelMapper = modelMapper;
        this.continenteService = continenteService;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass)
    {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    public CiudadPaisEntity cityDto2CityEnt(CiudadPaisDto ciudadPaisDto)
    {
        ContinenteEntity continenteDto = continenteService.findById(ciudadPaisDto.getIdContinente());
        CiudadPaisEntity city = modelMapper.map(ciudadPaisDto, CiudadPaisEntity.class);
        city.setContinente(continenteDto);
        return city;
    }

    // update the city with dto to city mapper
    public CiudadPaisEntity updateCity(CiudadPaisDto ciudadPaisDto, CiudadPaisEntity ciudadPaisEntity)
    {
        ContinenteEntity con = null;
        if (ciudadPaisDto.getDenominacion() != null
            && !ciudadPaisDto.getDenominacion().contentEquals(ciudadPaisEntity.getDenominacion()))
            ciudadPaisEntity.setDenominacion(ciudadPaisDto.getDenominacion());
        if (ciudadPaisDto.getImg() != null && !ciudadPaisDto.getImg().contentEquals(ciudadPaisEntity.getImg()))
            ciudadPaisEntity.setImg(ciudadPaisDto.getImg());
        if (ciudadPaisDto.getCantHabitante() != null && !(ciudadPaisDto.getCantHabitante() <= 0))
            ciudadPaisEntity.setCantHabitante(ciudadPaisDto.getCantHabitante());
        if (ciudadPaisDto.getSuperficie() != null && ciudadPaisDto.getSuperficie() != 0)
            ciudadPaisEntity.setSuperficie(ciudadPaisDto.getSuperficie());
        if (ciudadPaisDto.getIdContinente() != null && !(ciudadPaisDto.getIdContinente() <= 0))
            con = continenteService.findById(ciudadPaisDto.getIdContinente());

        if (con != null)
            ciudadPaisEntity.setContinente(con);
        return ciudadPaisEntity;

    }

}
