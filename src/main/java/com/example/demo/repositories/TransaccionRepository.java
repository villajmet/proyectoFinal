package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Transaccion;


public interface TransaccionRepository extends JpaRepositoryImplementation<Transaccion, Long> {

	List<Transaccion> findByIdPersona(Long idPersona);
}
