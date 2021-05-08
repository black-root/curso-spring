package com.curso.spring.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto {

	private Long idPelicula;
	private String titulo;
	private String descripcion;
	private String sinopsis;
	private String uriImagen;
	private BigDecimal precioVenta;
	private BigDecimal precioRenta;
	private Integer existencia;
	private CategoriaPeliculaDto categoria;
}
