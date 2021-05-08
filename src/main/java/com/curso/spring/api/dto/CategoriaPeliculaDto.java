package com.curso.spring.api.dto;

import com.curso.spring.api.model.EstadoCategoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaPeliculaDto {
	
	private Long idCategoria;
	private String nombre;
	private EstadoCategoria estado;
	
}
