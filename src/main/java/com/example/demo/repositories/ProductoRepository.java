package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Producto;


public interface ProductoRepository extends JpaRepositoryImplementation<Producto, Long> {

}