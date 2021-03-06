package com.curso.spring.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.curso.spring.api.model.Usuario;
import com.curso.spring.api.repository.PeliculaRepository;
import com.curso.spring.api.repository.UsuarioRepository;

@SpringBootTest
class PeliculaApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setEmail("ronald.ibanez1994@gmail.com");
		usuario.setPassword(encoder.encode("1234"));
		Usuario response = usuarioRepository.save(usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setEmail("admin");
		usuario2.setPassword(encoder.encode("admin"));
		usuarioRepository.save(usuario2);
		assertTrue(response.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}

}
