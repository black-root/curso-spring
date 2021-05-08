package com.curso.spring.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_pelicula", schema = "administracion")
public class CategoriaPelicula {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	@Column
	private String nombre;
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoCategoria estado;
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public EstadoCategoria getEstado() {
		return estado;
	}
	public void setEstado(EstadoCategoria estado) {
		this.estado = estado;
	}
	
	
}
