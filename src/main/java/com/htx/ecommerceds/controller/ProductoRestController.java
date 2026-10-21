package com.htx.ecommerceds.controller;

import com.htx.ecommerceds.model.Producto;
import com.htx.ecommerceds.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoRestController {

	private final ProductoService productoService;

	@GetMapping
	public List<Producto> listar() {
		return productoService.listarTodos();
	}

	@GetMapping("/{id}")
	public Producto obtener(@PathVariable Long id) {
		return productoService.obtener(id);
	}

	@PostMapping
	public Producto crear(@RequestBody Producto p) {
		return productoService.guardar(p);
	}

	@PutMapping("/{id}")
	public Producto actualizar(@PathVariable Long id, @RequestBody Producto p) {
		Producto existente = productoService.obtener(id);
		existente.setNombre(p.getNombre());
		existente.setDescripcion(p.getDescripcion());
		existente.setPrecio(p.getPrecio());
		existente.setStock(p.getStock());
		existente.setImagenUrl(p.getImagenUrl());
		return productoService.guardar(existente);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		productoService.eliminar(id);
	}
}