package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String nombre;
	private String categoria;
	private float  precio;
		
/*	@OneToMany(mappedBy = "transaccion")
    @JsonManagedReference
	private List<Transaccion> transacciones = new ArrayList<>();*/
	
	
}