package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
public class Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransaccion;
	@Temporal(TemporalType.DATE)
	private Date fechaTransaccion;
	private float  precio;
	
	private Long  idPersona;
	private Long  idProducto;
	/*
	@OneToMany
	private Persona persona;*/
	
}
