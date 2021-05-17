package com.curso.spring.api.service.implentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curso.spring.api.config.ApplicationUserRoles;
import com.curso.spring.api.exception.NotFoundException;
import com.curso.spring.api.model.Usuario;
import com.curso.spring.api.repository.UsuarioRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = this.usuarioRepository.findByEmail(username).orElseThrow(
				()-> new NotFoundException("usuario no encontrado"));
		
		/*
		 * List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		 * roles.add(new SimpleGrantedAuthority("ADMIN")); User userDetails = new User
		 * (usuario.getEmail(), usuario.getPassword(), roles);
		 */
		
		UserDetails userDetails = User.builder()
				.username(usuario.getEmail())
				.password(usuario.getPassword())
				.roles(ApplicationUserRoles.ADMIN.name())
				.build();
		
		log.info("user "+userDetails.toString());
		return userDetails;
	}

}
