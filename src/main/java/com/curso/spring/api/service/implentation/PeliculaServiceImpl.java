package com.curso.spring.api.service.implentation;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.spring.api.dto.PeliculaDto;
import com.curso.spring.api.model.Pelicula;
import com.curso.spring.api.repository.PeliculaRepository;
import com.curso.spring.api.service.PeliculaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<PeliculaDto> findAllList() {
		this.modelMapper = new ModelMapper();
		// TODO Auto-generated method stub
		return peliculaRepository.findAll().stream()
				.map(element -> modelMapper.map(element, PeliculaDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public Page<PeliculaDto> findAll(int page, int size) {
		this.modelMapper = new ModelMapper();
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return  peliculaRepository.findAll(pageable)
				.map(element -> modelMapper.map(element, PeliculaDto.class));
	}
	
	@Override
	public PeliculaDto save(PeliculaDto request) {
		this.modelMapper = new ModelMapper();
		Pelicula pelicula = modelMapper.map(request, Pelicula.class);
		log.info("pelicula "+pelicula);
		pelicula = peliculaRepository.save(pelicula);
		
		return modelMapper.map(pelicula, PeliculaDto.class);
	}


}
