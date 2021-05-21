package com.curso.spring.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto {

	private Long idPelicula;
	@Pattern(regexp = "[\\D]+", message = "Solo se permite letras")
	private String titulo;
	private String descripcion;
	private String sinopsis;
	private String uriImagen;
	private BigDecimal precioVenta;
	private BigDecimal precioRenta;
	private Integer existencia;
	private CategoriaPeliculaDto categoria;
}
