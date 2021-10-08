package com.icons.geographic.start.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.CiudadFilterDto;
import com.icons.geographic.start.dto.CiudadPaisAndIconDto;
import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.error.MesaggeError;
import com.icons.geographic.start.mapper.CiudadMapper;
import com.icons.geographic.start.repository.CiudadPaisRepository;
import com.icons.geographic.start.repository.ContinenteRepository;
import com.icons.geographic.start.service.CiudadPaisService;

@Service
public class CiudadPaisImpl implements CiudadPaisService {

	private CiudadPaisRepository ciudadPaisRepository;

	private CiudadMapper ciudadMapper;

	@Autowired
	public CiudadPaisImpl(CiudadPaisRepository ciudadPaisRepositor,
			CiudadMapper ciudadMapper) {
		this.ciudadPaisRepository = ciudadPaisRepositor;
		this.ciudadMapper = ciudadMapper;

	}

	@Override // Obtains all cities
	public List<CiudadPaisCompressDto> getEntity() throws MesaggeError {
		List<CiudadPaisEntity> ciu = ciudadPaisRepository.findAll();
		if (ciu != null) {
			List<CiudadPaisCompressDto> all = this.ciudadMapper.mapList(ciu,
					CiudadPaisCompressDto.class);
			if (all != null) {
				return all;
			}
			throw new MesaggeError("Entity Empty to search all" + all);
		}
		throw new MesaggeError("Entity Empty to search ciu" + ciu);
	}

	@Override // Save the city
	public CiudadPaisEntity saveCity(CiudadPaisDto ciudadPaisDto)
			throws MesaggeError {
		CiudadPaisEntity city = this.ciudadMapper
				.cityDto2CityEnt(ciudadPaisDto);
		if (city != null) {
			return this.ciudadPaisRepository.save(city);
		} else {
			throw new MesaggeError("Entity Empty to search city" + city);
		}
	}

	@Override // Obtains all cities with its icons
	public List<CiudadPaisAndIconDto> getCityAndIcon() throws MesaggeError {
		List<CiudadPaisEntity> ciudadEntity = this.ciudadPaisRepository
				.findAll();
		if (ciudadEntity != null) {

			List<CiudadPaisAndIconDto> ciudadAndIcon = ciudadMapper
					.mapList(ciudadEntity, CiudadPaisAndIconDto.class);
			if (ciudadAndIcon != null) {
				return ciudadAndIcon;
			}
			throw new MesaggeError(
					"Entity Empty to search ciudadAndIcon" + ciudadAndIcon);
		} else {
			throw new MesaggeError(
					"Entity Empty to search ciudadEntity" + ciudadEntity);
		}
	}

	@Override
	public void updatePais(CiudadPaisDto ciudadPaisDto, Long id)
			throws MesaggeError {

		if (id != 0 && id != null) {
			CiudadPaisEntity ciudadPaisEntity = this.ciudadPaisRepository
					.findById(id).get();
			CiudadPaisEntity ciudadPaisEntity2 = ciudadMapper
					.updateCity(ciudadPaisDto, ciudadPaisEntity);
			this.ciudadPaisRepository.save(ciudadPaisEntity2);

		} else {
			throw new MesaggeError("Id or ciudadPaisDto null or empty " + id
					+ " " + ciudadPaisDto);
		}
	}

	@Override
	public void deleteCity(Long id) throws MesaggeError {
		if (id != 0 && id != null) {
			this.ciudadPaisRepository.deleteById(id);
		} else {
			throw new MesaggeError("Error to ID id empty or null " + id);
		}

	}

	@Override
	public List<CiudadPaisAndIconDto> searchCity(String name, Set<Long> idCont,
			String ascDesc) throws MesaggeError {
		CiudadFilterDto filter = new CiudadFilterDto(name, idCont, ascDesc);

		List<CiudadPaisEntity> cityEntity = this.ciudadPaisRepository
				.getFilterCities(filter);
		if (cityEntity != null) {
			List<CiudadPaisAndIconDto> listResult = this.ciudadMapper
					.mapList(cityEntity, CiudadPaisAndIconDto.class);
			if (listResult != null) {
				return listResult;
			} else {
				throw new MesaggeError("listResult is null " + listResult);
			}
		} else {
			throw new MesaggeError("cityEntity is null " + cityEntity);
		}

	}

}
