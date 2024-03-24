package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Producto;

public interface ProductoService {
	List<Producto> listarTodos();	
	Producto buscarPorId(long id);	
	Producto grabar(Producto producto);
	void eliminar(long id);
}