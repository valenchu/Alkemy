package com.icons.geographic.start.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.CiudadPaisAndIconDto;
import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
import com.icons.geographic.start.error.MesaggeError;
import com.icons.geographic.start.service.CiudadPaisService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("cp")
@CrossOrigin("*")
public class CiudadPaisController {

	private CiudadPaisService ciudadPaisService;

	@Autowired
	public CiudadPaisController(CiudadPaisService ciudadPaisService) {
		this.ciudadPaisService = ciudadPaisService;
	}

	@GetMapping("cities")
	@Operation(summary = "find all list cities for img and name")
	public ResponseEntity<?> listCity() {
		List<CiudadPaisCompressDto> citieSearch = ciudadPaisService.getEntity();
		return new ResponseEntity<>(citieSearch, HttpStatus.OK);
	}

	@GetMapping("citiesIcon")
	@Operation(summary = "Return a list of cities and icons details")
	public ResponseEntity<?> listCityAndIcon() throws MesaggeError {
		try {
			List<CiudadPaisAndIconDto> cityAndIcon = ciudadPaisService
					.getCityAndIcon();
			return new ResponseEntity<>(cityAndIcon, HttpStatus.OK);
		} catch (Exception e) {
			throw new MesaggeError(e.getMessage());
		}
	}

	@GetMapping("findCityFilter")
	@Operation(summary = "Find cities for name,idContinent,order ASC(ascending) - DESC(descending)")
	public ResponseEntity<?> findCityFilter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Set<Long> idContinent,
			@RequestParam(required = false, defaultValue = "DESC", name = "Insert DESC or ASC") String order)
			throws MesaggeError {
		if (order != null && !order.equalsIgnoreCase("ASC")
				&& !order.equalsIgnoreCase("DESC")) {
			throw new MesaggeError(
					"Insert the correct parameter of ORDER = ASC or DESC "
							+ order);
		} else {
			List<CiudadPaisAndIconDto> result = ciudadPaisService
					.searchCity(name, idContinent, order);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

	}

	@PostMapping("addCity")
	@Operation(summary = "add city to BD")
	public ResponseEntity<?> addCity(@RequestBody CiudadPaisDto ciudadPaisDto)
			throws MesaggeError {
		try {
			CiudadPaisEntity city = ciudadPaisService.saveCity(ciudadPaisDto);
			return new ResponseEntity<>(city, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new MesaggeError(e.getMessage());
		}
	}

	@PutMapping("editCity/{id}")
	@Operation(summary = "Edit a city to eleccion")
	public ResponseEntity<?> editCity(@RequestBody CiudadPaisDto ciudadPaisDto,
			@PathVariable(value = "id", required = true) Long id)
			throws MesaggeError {
		if (id != null && id != 0) {
			ciudadPaisService.updatePais(ciudadPaisDto, id);
			String re = "ALL OK";
			return new ResponseEntity<>(re, HttpStatus.OK);
		} else {
			throw new MesaggeError("City or ID empty or null " + id + " "
					+ ciudadPaisDto.toString());
		}

	}

	@DeleteMapping("dellCity/{id}")
	@Operation(summary = "Deleted the city")
	public ResponseEntity<?> deletedCity(@PathVariable(value = "id") Long id)
			throws MesaggeError {
		ciudadPaisService.deleteCity(id);
		String re = "ALL OK";
		return new ResponseEntity<>(re, HttpStatus.OK);
	}
}
