package com.icons.geographic.start.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.icons.geographic.start.dto.EnrrollIconToCity;
import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.dto.IconDtoMinimized;
import com.icons.geographic.start.dto.IconFilterDto;
import com.icons.geographic.start.entity.IconGeograficoEntity;

public interface IconGeoService {

    public List<IconDtoMinimized> getResp();

    public <T> IconGeograficoEntity finAll(Object a);

    public <T> IconGeograficoEntity updateIcon(IconDtoEdited iconDto, Long id);

    public List<IconDto> getRespMax();

    public void deleted(Long id);

    public List<IconDto> getEntity();

    public IconGeograficoEntity enrrolToCity(EnrrollIconToCity enrrollIconToCity);

    public List<IconDto> search(String deno, LocalDate date, Set<Long> idCity) throws Exception;
  
}
