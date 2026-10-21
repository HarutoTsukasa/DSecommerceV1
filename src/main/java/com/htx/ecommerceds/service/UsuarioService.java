package com.htx.ecommerceds.service;

import com.htx.ecommerceds.model.Usuario;
import java.util.List;
import java.util.Optional;

/** Contrato de operaciones sobre usuarios. */
public interface UsuarioService {

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorEmail(String email);

    /**
     * Login temporal mientras no exista Spring Security.
     * Compara la contraseña en texto plano. Será reemplazado por BCrypt.
     */
    boolean loginValido(String email, String password);

    Usuario guardar(Usuario usuario);
}