package com.icons.geographic.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.error.MesaggeError;
import com.icons.geographic.start.mapper.ContinenteMapper;
import com.icons.geographic.start.repository.ContinenteRepository;
import com.icons.geographic.start.service.ContinenteService;

@Service
public class ContinenteImpl implements ContinenteService
{

    private final ContinenteRepository continenteRepository;

    private final ContinenteMapper mapCont;

    @Autowired
    public ContinenteImpl(ContinenteRepository continenteRepository, ContinenteMapper mapCont)
    {
        this.continenteRepository = continenteRepository;
        this.mapCont = mapCont;
    }

    // save img and name of continent
    public ContinenteEntity saveCont(ContinenteDto continenteDto)
    {
        ContinenteEntity con = mapCont.dtoToCont(continenteDto);
        return continenteRepository.save(con);
    }

    // get all continent in the DB
    public List<ContinenteDto> findAll()
    {
        List<ContinenteEntity> i = continenteRepository.findAll();
        List<ContinenteDto> cdto = mapCont.mapList(i, ContinenteDto.class);
        return cdto;
    }

    // update continent for id
    public ContinenteEntity updateContinent(Long id, ContinenteDto continenteDto)
    {
        ContinenteEntity con = continenteRepository.findById(id).get();
        con = mapCont.guar(con, continenteDto);
        return continenteRepository.save(con);
    }

    // delete continent for id
    public void deleteContinent(Long id)
    {
        ContinenteEntity con = continenteRepository.findById(id).get();
        continenteRepository.delete(con);
    }

    @Override
    public ContinenteEntity findById(Long id) throws MesaggeError
    {
        ContinenteEntity defaultContienete = null;
        if (id != null && id != 0) {

            defaultContienete = continenteRepository.findById(id).get();

            if (defaultContienete != null) {

                return defaultContienete;

            }
            throw new MesaggeError("Object empty or null " + defaultContienete);
        } else {
            throw new MesaggeError("Error id empty " + id);
        }

    }

}
