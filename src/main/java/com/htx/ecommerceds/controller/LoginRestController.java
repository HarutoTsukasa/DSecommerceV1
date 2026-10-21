package com.htx.ecommerceds.controller;

import com.htx.ecommerceds.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginRestController {

    private final UsuarioService usuarioService;

    /** Login SIN seguridad: solo verifica credenciales. Spring Security lo reemplazará. */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        boolean ok = usuarioService.loginValido(body.get("email"), body.get("password"));
        return Map.of("autenticado", ok);
    }
}