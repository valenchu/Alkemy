package com.movie.start.service;

import java.util.List;
import java.util.Set;

import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.model.dto.MovieListBasicDto;
import com.movie.start.model.entity.MovieEntity;

public interface MovieService {
	public void createMovWithGender(MovieCompressDto movieDto, Set<Long> id);

	public List<MovieListBasicDto> searchMovieBasic();

	public List<MovieEntity> getListMovieEntity();

	public MovieEntity enrrollMovChar(Long idMov, Set<Long> idChar);

	public MovieCompressDto editMovie(MovieCompressDto movieDto, Long idMovie);

	public void delete(Long id);

	public List<MovieEntity> filterMovie(String name, Set<Long> idGender, String order);
}
