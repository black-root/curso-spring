package com.curso.spring.api.service.implentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.api.dto.PeliculaDto;
import com.curso.spring.api.repository.PeliculaRepository;
import com.curso.spring.api.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<PeliculaDto> findAll() {
		// TODO Auto-generated method stub
		return peliculaRepository.findAll().stream()
				.map(element -> modelMapper.map(element, PeliculaDto.class)).collect(Collectors.toList());
	}

}
