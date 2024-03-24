package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Producto;
import com.example.demo.services.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService proService;
	
	
	@GetMapping
	public List<Producto>  ListarProductos(){
		return proService.listarTodos();
	}
	

	@PostMapping
	public Producto crearInvestigador(@RequestBody Producto persona){
		return proService.grabar(persona);
	}
		
	@DeleteMapping("/{id}")
	public void eliminarPersona(@PathVariable Long id){
		proService.eliminar(id);
	}
	
}
