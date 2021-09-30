package com.icons.geographic.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.service.ContienenteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("continente")
@CrossOrigin("*")
public class ContinenteController {

    private final ContienenteService contienenteService;

    @Autowired
    public ContinenteController(ContienenteService contienenteService) {
	this.contienenteService = contienenteService;
    }

    @PostMapping("saveContinente")
    @Operation(summary = "Insert img the continent and name the continent")
    public ResponseEntity<?> saveCont(@RequestBody ContinenteDto continenteDto,
	    @Parameter(description = "Img of continent") @RequestParam String img,
	    @Parameter(description = "Name of continent") @RequestParam String nomContinente) {
	
	ContinenteEntity continenteEntity = contienenteService.saveCont(continenteDto,img,nomContinente);
	return new ResponseEntity<>(continenteEntity, HttpStatus.ACCEPTED);
    }

    @GetMapping("allContinent")
    @Operation(summary = "Obtain all the continent")
    public ResponseEntity<?> allContinent() {
	return new ResponseEntity<>(contienenteService.findAll(), HttpStatus.OK);
    }

    @PutMapping("updateContinent/{id}")
    @Operation(summary = "Update for id the continent")
    public ResponseEntity<?> updateContinent(@PathVariable(value = "id") Long id,
	    @RequestBody ContinenteDto continenteDto) {
	

	return null;

    }

}
