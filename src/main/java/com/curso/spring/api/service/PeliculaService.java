package com.curso.spring.api.service;

import java.util.List;

import com.curso.spring.api.dto.PeliculaDto;

public interface PeliculaService {

	List<PeliculaDto> findAll();

}
