package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Transaccion;


public interface TransaccionService {
	List<Transaccion> listarTodos();	
	Transaccion grabar(Transaccion persona);	
	void eliminar(long id);	
}
