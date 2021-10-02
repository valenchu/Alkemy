package com.icons.geographic.start.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.icons.geographic.start.dto.IconDto;
import com.icons.geographic.start.dto.IconDtoEdited;
import com.icons.geographic.start.dto.IconDtoMinimized;
import com.icons.geographic.start.entity.IconGeograficoEntity;
import com.icons.geographic.start.service.IconGeoService;

import io.swagger.v3.oas.annotations.Operation;

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
    public ResponseEntity<?> addIcon(@RequestBody IconDtoEdited iconDto) {
	IconGeograficoEntity ico = iconGeoService.finAll(iconDto);
	return new ResponseEntity<>(ico, HttpStatus.CREATED);

    }

    @PostMapping("addIconCity")
    @Operation(summary = "add icon and city to the database")
    public ResponseEntity<?> addIconAndCity(@RequestBody IconDto iconnDto) {
	IconGeograficoEntity ico = iconGeoService.finAll(iconnDto);
	return new ResponseEntity<>(ico, HttpStatus.CREATED);

    }

    @GetMapping("list")
    @Operation(summary = "find all list icon for img and name")
    public ResponseEntity<?> listIcon() {
	List<IconDtoMinimized> iconDtoMinimized = iconGeoService.getResp();
	return new ResponseEntity<>(iconDtoMinimized, HttpStatus.OK);
    }
    
    @GetMapping("list2")
    @Operation(summary = "find all list icon for img and name")
    public ResponseEntity<?> listIcon2() {
	List<IconGeograficoEntity> iconDtoMinimized = iconGeoService.getEntity();
	return new ResponseEntity<>(iconDtoMinimized, HttpStatus.OK);
    }

    @DeleteMapping("dellIcon/{id}")
    @Operation(summary = "dell icon BD")
    public ResponseEntity<?> dellIcon(@PathVariable(value = "id") Long id) {
	iconGeoService.deleted(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("allDetailsIcon")
    @Operation(summary = "all details to icon")
    public ResponseEntity<?> allIconDetails() {
	List<IconDto> fullIcon = iconGeoService.getRespMax();
	return new ResponseEntity<>(fullIcon, HttpStatus.OK);
    }

    @PutMapping("upIcon/{id}")
    @Operation(summary = "update icon for id")
    public ResponseEntity<?> updateIcon(@PathVariable(value = "id") Long id, @RequestBody IconDtoEdited iconDto) {
	IconGeograficoEntity ico = iconGeoService.updateIcon(iconDto, id);
	return new ResponseEntity<>(ico, HttpStatus.OK);

    }
}
