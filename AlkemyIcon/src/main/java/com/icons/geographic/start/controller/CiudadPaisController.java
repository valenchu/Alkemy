package com.icons.geographic.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.CiudadPaisCompressDto;
import com.icons.geographic.start.dto.CiudadPaisDto;
import com.icons.geographic.start.entity.CiudadPaisEntity;
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
    public ResponseEntity<?> listIcon2() {
	List<CiudadPaisCompressDto> citieSearch = ciudadPaisService.getEntity();
	return new ResponseEntity<>(citieSearch, HttpStatus.OK);
    }

    @PostMapping("addCity")
    @Operation(summary = "add city to BD")
    public ResponseEntity<?> addCity(@RequestBody CiudadPaisDto ciudadPaisDto) {
	CiudadPaisEntity city = ciudadPaisService.saveCity(ciudadPaisDto);
	return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

}
