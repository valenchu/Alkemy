package com.icons.geographic.start.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.service.IconGeoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("icon")
@CrossOrigin("*")
public class IconGeoController {

    private final IconGeoService iconGeoService;

    @Autowired
    public IconGeoController(IconGeoService iconGeoService) {
	this.iconGeoService = iconGeoService;

    }
//    private String img;
//    private String denominacion;
//    private LocalDate fechaCreacion;
//    private Float altura;
//    private String historia;
//    private CiudadPaisDto ciudadPais;

    @PostMapping("addIcon")
    @Operation(summary = "add icon to the database")
    public ResponseEntity<?> addIcon(@RequestBody IconDto iconDto) {
	IconGeograficoEntity iconGeograficoEntity = iconGeoService.finAll(iconDto);
	return new ResponseEntity<>(iconGeoService, HttpStatus.CREATED);

    }

    @GetMapping("List")
    public List<IconGeograficoEntity> test() {
	return iconGeoService.getResp();
    }

//    @PostMapping("CargaIc")
//    public 
}
