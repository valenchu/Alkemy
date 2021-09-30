package com.icons.geographic.start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.repository.IconRepository;


public interface IconGeoService {

    public List<IconGeograficoEntity> getResp();
}
