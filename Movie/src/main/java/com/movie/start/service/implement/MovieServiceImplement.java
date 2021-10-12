package com.movie.start.service.implement;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.model.entity.MovieEntity;
import com.movie.start.repository.MovieRepository;
import com.movie.start.service.MovieService;
import com.movie.start.service.mapper.MovieMapper;

@Service
public class MovieServiceImplement implements MovieService {
	private MovieMapper movieMapper;
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImplement(MovieMapper movieMapper,
			MovieRepository movieRepository) {
		this.movieMapper = movieMapper;
		this.movieRepository = movieRepository;
	}

	@Override
	public void createMovWithGender(MovieCompressDto movieDto, Set<Long> id) {
		MovieEntity movie = movieMapper.movieDto2MovieEntity(movieDto, id);
		movieRepository.save(movie);

	}

}
