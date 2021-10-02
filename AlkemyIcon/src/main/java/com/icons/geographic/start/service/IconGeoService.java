package com.icons.geographic.start.service;

import java.util.List;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.dto.IconDtoMinimized;
import com.icons.geographic.start.entity.IconGeograficoEntity;

public interface IconGeoService {

    public List<IconDtoMinimized> getResp();

    public <T> IconGeograficoEntity finAll(Object a);

    public <T> IconGeograficoEntity updateIcon(IconDtoEdited iconDto, Long id);

    public List<IconDto> getRespMax();

    public void deleted(Long id);

    public List<IconGeograficoEntity> getEntity();
}
