package com.htx.ecommerceds.controller;

import com.htx.ecommerceds.model.Orden;
import com.htx.ecommerceds.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller @RequiredArgsConstructor
public class AdminController {

    private final ProductoService productoService;
    private final OrdenService ordenService;
    private final UsuarioService usuarioService;

    @GetMapping("/admin")
    public String admin(Model model) {
        var ordenes = ordenService.listarTodas();
        var productos = productoService.listarTodos();
        var usuarios = usuarioService.listarTodos();

        BigDecimal ingresos = ordenes.stream()
                .map(Orden::getTotal)
                .filter(java.util.Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("ordenes", ordenes);
        model.addAttribute("productos", productos);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalVentas", ingresos);
        model.addAttribute("totalPedidos", ordenes.size());
        model.addAttribute("totalClientes", usuarios.stream()
                .filter(u -> "CLIENTE".equals(u.getRol())).count());
        return "admin";
    }
}