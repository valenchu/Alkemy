package com.movie.start.service;

import java.util.Set;

import com.movie.start.model.dto.MovieCompressDto;

public interface MovieService {
	public void createMovWithGender(MovieCompressDto movieDto, Set<Long> id);
}
