package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Persona implements Serializable{

	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

	private String paterno;
	private String materno;
	private String nombres;	
	@Column(unique = true)
	private String email;	
	@Column(unique = true)
	private String dni;
	
	/*
	@ManyToMany
	@JoinTable(name = "transaccion",
		joinColumns = @JoinColumn(name="idPersona"),
		inverseJoinColumns = @JoinColumn(name="idTransaccion")
			)
	private List<Transaccion> transacciones;*/
	
	/*
	@OneToMany(mappedBy = "transaccion")
    @JsonManagedReference
	private List<Transaccion> transacciones = new ArrayList<>();
	*/
}
