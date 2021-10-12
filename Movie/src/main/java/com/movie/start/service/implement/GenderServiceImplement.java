package com.movie.start.service.implement;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.model.entity.GenderEntity;
import com.movie.start.repository.GenderRepository;
import com.movie.start.service.GenderService;
import com.movie.start.service.mapper.GenderMapper;

@Service
public class GenderServiceImplement implements GenderService {

    private GenderRepository genderRepo;
    private GenderMapper genderMapper;

    @Autowired
    public GenderServiceImplement(GenderRepository genderRepo, GenderMapper genderMapper) {
	this.genderRepo = genderRepo;
	this.genderMapper = genderMapper;
    }

    @Override
    public GenderCompressDto createGender(GenderCompressDto genderDto) throws MesaggeError {
	if (!Objects.isNull(genderDto)) {
	    GenderEntity genderEnt = genderMapper.genderDto2GenderEntity(genderDto);
	    genderRepo.save(genderEnt);
	    return genderDto;
	}
	throw new MesaggeError("Object empty or null " + genderDto.toString());
    }

    @Override
    public List<GenderEntity> getByIdGender(Set<Long> id) throws MesaggeError {
	List<GenderEntity> gen = null;
	if (id != null) {
	    gen = genderRepo.findAllById(id);
	    return gen;

	}
	throw new MesaggeError("Id or gen null " + gen);
    }

}
