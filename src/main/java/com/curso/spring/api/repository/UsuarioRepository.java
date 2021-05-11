package com.curso.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
