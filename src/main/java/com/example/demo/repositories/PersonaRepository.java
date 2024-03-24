package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Persona;


public interface PersonaRepository extends JpaRepositoryImplementation<Persona, Long> {

	 Optional<Persona> findByDni(String dni);
	 Optional<Persona> findByEmail(String email);
}

