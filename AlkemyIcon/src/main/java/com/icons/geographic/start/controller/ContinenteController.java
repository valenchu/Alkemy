package com.icons.geographic.start.controller;

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
    public ResponseEntity<?> saveCont(@RequestBody ContinenteDto continenteDto){

	ContinenteEntity continenteEntity = contienenteService.saveCont(continenteDto);
	return new ResponseEntity<>(continenteEntity, HttpStatus.CREATED);
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

	return new ResponseEntity<>(contienenteService.updateContinent(id, continenteDto), HttpStatus.OK);

    }

    @DeleteMapping("deleteContinent/{id}")
    @Operation(summary = "Delete for id the continent")
    public ResponseEntity<?> deleteContinent(@PathVariable(value = "id") Long id) {
	contienenteService.deleteContinent(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
