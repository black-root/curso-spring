package com.curso.spring.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.curso.spring.api.dto.PeliculaDto;

public interface PeliculaService {

	List<PeliculaDto> findAllList();

	Page<PeliculaDto> findAll(int page, int size);
	
	PeliculaDto save(PeliculaDto request);
}
