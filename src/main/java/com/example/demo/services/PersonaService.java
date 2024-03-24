package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Persona;


public interface PersonaService {
	List<Persona> listarTodos();	
	Persona buscarPorId(long id);	
	Persona grabar(Persona persona);
	Persona actualizar(Persona persona, Long id);	
	void eliminar(long id);	
	Persona findByEmail(String email);
	Persona findByDni(String dni);
}
