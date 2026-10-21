package com.htx.ecommerceds.controller;

import com.htx.ecommerceds.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final ProductoService productoService;

	@GetMapping({ "/", "/index" })
	public String landing(Model model) {
		model.addAttribute("productos", productoService.listarTodos());
		return "index";
	}
}