package com.htx.ecommerceds.controller;

import com.htx.ecommerceds.model.Orden;
import com.htx.ecommerceds.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenRestController {

	private final OrdenService ordenService;

	@GetMapping
	public List<Orden> listar() {
		return ordenService.listarTodas();
	}

	@PatchMapping("/{id}/estado")
	public Orden actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
		return ordenService.actualizarEstado(id, body.get("estado"));
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		ordenService.eliminar(id);
	}
}