package com.movie.start.service.implement;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.start.error.MesaggeError;
import com.movie.start.model.dto.MovieCompressDto;
import com.movie.start.model.dto.MovieFilterDto;
import com.movie.start.model.dto.MovieListBasicDto;
import com.movie.start.model.entity.CharacterEntity;
import com.movie.start.model.entity.MovieEntity;
import com.movie.start.repository.MovieRepository;
import com.movie.start.repository.specialization.MovieRepoSpecialization;
import com.movie.start.service.CharacterService;
import com.movie.start.service.MovieService;
import com.movie.start.service.mapper.MovieMapper;

@Service
public class MovieServiceImplement implements MovieService {
	// Mapper
	private MovieMapper movieMapper;
	// Repo
	private MovieRepository movieRepository;
	private MovieRepoSpecialization movieRepoSpecialization;
	// Service
	private CharacterService characterService;

	@Autowired
	public MovieServiceImplement(MovieMapper movieMapper, MovieRepository movieRepository,
			CharacterService characterService, MovieRepoSpecialization movieRepoSpecialization) {
		this.movieMapper = movieMapper;
		this.movieRepository = movieRepository;
		this.characterService = characterService;
		this.movieRepoSpecialization = movieRepoSpecialization;
	}

	@Override
	public void createMovWithGender(MovieCompressDto movieDto, Set<Long> id) {
		MovieEntity movie = movieMapper.movieDto2MovieEntity(movieDto, id);
		movieRepository.save(movie);

	}

	@Override
	public List<MovieListBasicDto> searchMovieBasic() throws MesaggeError {
		try {
			List<MovieEntity> movieEntity = movieRepository.findAll();
			List<MovieListBasicDto> movieBasic = movieMapper.mapList(movieEntity, MovieListBasicDto.class);
			return movieBasic;
		} catch (Exception e) {
			throw new MesaggeError("Error in the search BD " + e.getMessage());
		}
	}

	@Override
	public List<MovieEntity> getListMovieEntity() throws MesaggeError {
		try {
			List<MovieEntity> movie = movieRepository.findAll();
			return movie;
		} catch (Exception e) {
			throw new MesaggeError("Fields no found in the bd " + e.getMessage());
		}

	}

	@Override
	public List<MovieEntity> filterMovie(String name, Set<Long> idGender, String order) {

		MovieFilterDto filterDto = new MovieFilterDto(name, idGender, order);
		try {
			List<MovieEntity> listFilterEntity = this.movieRepository
					.findAll(this.movieRepoSpecialization.getByFilter(filterDto));
			return listFilterEntity;
		} catch (Exception e) {
			throw new MesaggeError("Error empty or bad request " + e);
		}
	}

	@Override
	public MovieEntity enrrollMovChar(Long idMov, Set<Long> idChar) throws MesaggeError {
		List<CharacterEntity> charEntity = null;
		MovieEntity movieEntity = null;
		if (idChar != null) {
			charEntity = characterService.getById(idChar);
		} else {
			throw new MesaggeError("id empty or null " + idChar);
		}
		if (idMov != null && idMov > 0) {
			movieEntity = movieRepository.findById(idMov).get();
		} else {
			throw new MesaggeError("id empty or null " + idMov);
		}
		movieMapper.enrrollMovieChar(movieEntity, charEntity);
		this.movieRepository.save(movieEntity);
		return movieEntity;
	}

	@Override
	public MovieCompressDto editMovie(MovieCompressDto movieDto, Long idMovie) {
		MovieEntity entity = null;
		if (idMovie != null && idMovie > 0) {
			entity = this.movieRepository.findById(idMovie).get();
		} else {
			throw new MesaggeError("idMovie less that cero or null " + idMovie);
		}
		if (!Objects.isNull(movieDto)) {
			movieMapper.refreshEntity(entity, movieDto);
			this.movieRepository.save(entity);
			MovieCompressDto comEntDto = movieMapper.movieEntity2Dto(entity, MovieCompressDto.class);
			return comEntDto;
		} else {
			throw new MesaggeError("movieDto null \n" + movieDto.toString());
		}

	}

	@Override
	public void delete(Long id) {
		if (id != null && id > 0) {
			this.movieRepository.deleteById(id);
			return;
		} else {
			throw new MesaggeError("ID INCORRECT " + id);
		}

	}

}
