package com.icons.geographic.start.service;

import java.time.LocalDate;
import java.util.List;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.entity.IconGeograficoEntity;


public interface IconGeoService {

    public List<IconGeograficoEntity> getResp();
    
    public IconGeograficoEntity finAll(IconDto iconDto);
}
