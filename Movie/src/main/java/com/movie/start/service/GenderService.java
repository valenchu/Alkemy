package com.movie.start.service;

import java.util.List;
import java.util.Set;

import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.model.entity.GenderEntity;

public interface GenderService {
    public GenderCompressDto createGender(GenderCompressDto genderDto);

    public List<GenderEntity> getByIdGender(Set<Long> id);
}
