package com.curso.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.api.dto.PeliculaDto;
import com.curso.spring.api.dto.ServiceResponse;
import com.curso.spring.api.dto.ServiceResponseFactory;
import com.curso.spring.api.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping
	public ResponseEntity<ServiceResponse> findAll(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size){
		return ServiceResponseFactory.createResponse(peliculaService.findAll(page, size));
	}
	
	@PostMapping
	public ResponseEntity<ServiceResponse> crear(@RequestBody PeliculaDto pelicula){
		return ServiceResponseFactory.createResponse(peliculaService.save(pelicula));
	}

}
