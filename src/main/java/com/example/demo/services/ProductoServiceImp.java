package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Producto;
import com.example.demo.repositories.ProductoRepository;


@Service
public class ProductoServiceImp implements ProductoService {

	
	@Autowired
	private ProductoRepository invRep;
		
	@Override
	@Transactional
	public List<Producto> listarTodos() {
		return invRep.findAll();
	}

	@Override
	@Transactional
	public Producto buscarPorId(long id) {
		Optional<Producto> investigador =  invRep.findById(id);
		return investigador.get();
	}

	@Override
	@Transactional
	public Producto grabar(Producto producto) {
		return invRep.save(producto);		
	}
	
	@Override
	@Transactional
	public void eliminar(long id) {
		invRep.deleteById(id);

	}
		

}