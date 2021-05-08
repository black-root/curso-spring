package com.curso.spring.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula", schema = "administracion")
public class Pelicula {

	@Id
	@Column(name = "id_pelicula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPelicula;
	@Column
	private String titulo;
	@Column
	private String descripcion;
	@Column
	private String sinopsis;
	@Column(name = "url_image")
	private String uriImagen;
	@Column(name = "precio_venta")
	private BigDecimal precioVenta;
	@Column(name = "precio_renta")
	private BigDecimal precioRenta;
	@Column
	private Integer existencia;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private CategoriaPelicula categoria;
	
	public Long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getUriImagen() {
		return uriImagen;
	}
	public void setUriImagen(String uriImagen) {
		this.uriImagen = uriImagen;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getPrecioRenta() {
		return precioRenta;
	}
	public void setPrecioRenta(BigDecimal precioRenta) {
		this.precioRenta = precioRenta;
	}
	public Integer getExistencia() {
		return existencia;
	}
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
}
