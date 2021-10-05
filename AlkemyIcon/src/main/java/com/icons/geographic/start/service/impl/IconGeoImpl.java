package com.icons.geographic.start.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.EnrrollIconToCity;
import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.dto.IconDtoMinimized;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.mapper.IconMapper;
import com.icons.geographic.start.repository.CiudadPaisRepository;
import com.icons.geographic.start.repository.IconRepository;
import com.icons.geographic.start.service.IconGeoService;

@Service
public class IconGeoImpl implements IconGeoService {

    private IconRepository iconRepository;
    private CiudadPaisRepository ciudadPaisRepository;
    private IconMapper mapCont;
    @PersistenceContext
    EntityManager em;

    @Autowired
    public IconGeoImpl(IconRepository iconRepository, CiudadPaisRepository ciudadPaisRepository, IconMapper mapCont) {
	this.iconRepository = iconRepository;
	this.ciudadPaisRepository = ciudadPaisRepository;
	this.mapCont = mapCont;
    }

    public List<IconDtoMinimized> getResp() {
	List<IconGeograficoEntity> listIcon = iconRepository.findAll();
	List<IconDtoMinimized> minimized = mapCont.mapList(listIcon, IconDtoMinimized.class);
	return minimized;

    }

    @Override
    public <T> IconGeograficoEntity updateIcon(IconDtoEdited iconDto, Long id) {
	IconGeograficoEntity iconUnic = iconRepository.findById(id).get();
	IconGeograficoEntity iU = mapCont.updateIcon(id, iconUnic, iconDto);
	iconUnic = iU;
	return iconRepository.save(iconUnic);
    }

    @Override
    public <T> IconGeograficoEntity finAll(Object a) {
	IconGeograficoEntity s = mapCont.dtoToIcon(a);
	return iconRepository.save(s);
    }

    @Override
    public void deleted(Long id) {
	iconRepository.deleteById(id);
    }

    @Override
    public List<IconDto> getRespMax() {
	List<IconGeograficoEntity> listIcon = iconRepository.findAll();
	List<IconDto> minimized = mapCont.mapList(listIcon, IconDto.class);
	return minimized;
    }

    @Override // find ic and parse to dto
    public List<IconDto> getEntity() {
	List<IconDto> ic = mapCont.mapList(iconRepository.findAll(), IconDto.class);
	return ic;
    }

    @Override // add icon and city for id
    public IconGeograficoEntity enrrolToCity(EnrrollIconToCity enrrollIconToCity) {
	Optional<IconGeograficoEntity> ic = iconRepository.findById(enrrollIconToCity.getIdIcon());
	Optional<CiudadPaisEntity> city = ciudadPaisRepository.findById(enrrollIconToCity.getIdCity());
	IconGeograficoEntity ic2 = null;
	if (ic.isPresent() && city.isPresent()) {
	    ic2 = mapCont.enrrolIconCity(ic.get(), city.get());
	}
	return iconRepository.save(ic2);
    }

    @Override
    public List<IconGeograficoEntity> search(String deno, LocalDate date, Long id) throws Exception {
	try {

//	    List<IconGeograficoEntity> icon = null;
//	    List<IconDtoEdited> iconEd = null;
//	    icon = iconRepository.search(deno);
//	    iconEd = mapCont.mapList(icon, IconDtoEdited.class);
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<IconGeograficoEntity> cq = cb.createQuery(IconGeograficoEntity.class);
	    Root<IconGeograficoEntity> iconCriteria = cq.from(IconGeograficoEntity.class);
	    CriteriaQuery<CiudadPaisEntity> cqP = cb.createQuery(CiudadPaisEntity.class);
	    Root<CiudadPaisEntity> ciudadCriteria = cqP.from(CiudadPaisEntity.class);
	    List<Predicate> predicate = new ArrayList<Predicate>();
	    
	    if (deno != null || deno != "") {
		predicate.add(cb.like(iconCriteria.get("denominacion"), "%" + deno + "%"));
	    }
//	    if (date != null) {
//		predicate.add(cb.like(iconCriteria.get("fechaCreacion"), "%" + date + "%"));
//	    }
	    if (id != null) {
		predicate.add(cb.like(iconCriteria.get("id"), "%" + id + "%"));
	    }
	    cq.where(predicate.toArray(Predicate[]::new));

	    return em.createQuery(cq).getResultList();

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}

    }

}
