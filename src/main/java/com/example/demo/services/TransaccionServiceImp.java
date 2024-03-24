package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Transaccion;
import com.example.demo.repositories.TransaccionRepository;



@Service
public class TransaccionServiceImp implements TransaccionService {

	
	@Autowired
	private TransaccionRepository invRep;
		
	@Override
	@Transactional
	public List<Transaccion> listarTodos() {
		return invRep.findAll();
	}

	

	@Override
	@Transactional
	public Transaccion grabar(Transaccion producto) {
		return invRep.save(producto);		
	}
	
	@Override
	@Transactional
	public void eliminar(long id) {
		invRep.deleteById(id);

	}
		

}
