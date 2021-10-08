package com.movie.start.service.implement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.model.dto.GenderCompressDto;
import com.movie.start.repository.GenderRepository;
import com.movie.start.service.GenderService;

@Service
public class GenderServiceImplement implements GenderService {
	
	private GenderRepository genderRepo;
	
	@Autowired
	public GenderServiceImplement(GenderRepository genderRepo) {
		this.genderRepo = genderRepo;
	}


	@Override
	public GenderCompressDto createGender(GenderCompressDto genderDto) {
		
		return null;
	}

}
