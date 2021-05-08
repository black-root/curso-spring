package com.curso.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.api.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
