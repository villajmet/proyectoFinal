package com.example.demo.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Usuario;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {

}
