package com.htx.ecommerceds.service.impl;

import com.htx.ecommerceds.model.Usuario;
import com.htx.ecommerceds.repository.UsuarioRepository;
import com.htx.ecommerceds.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public boolean loginValido(String email, String password) {
		if (email == null || password == null) {
			return false;
		}
		return usuarioRepository.findByEmail(email).map(u -> u.getPassword().equals(password)).orElse(false);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}