package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Transaccion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PersonaDTO {
	private Long idPersona;
	@NotBlank(message = "El email no puede estar en blanco")
	@Email(message = " El email no cumple con una estructura valida")
	private String email;
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 2, message = "El nombre debe tener al menos 3 caracteres")
	private String nombres;
	@NotBlank(message = "El apellido paterno no puede estar en blanco")
	@Size(min = 2, message = "El apellido paterno debe tener al menos 3 caracteres")
	private String paterno;
	@NotBlank(message = "El apellido materno no puede estar en blanco")
	@Size(min = 2, message = "El apellido materno debe tener al menos 3 caracteres")
	private String materno;
	@NotBlank(message = "El DNI no puede estar en blanco")
    @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres")
	@Pattern(regexp = "\\d+", message = "El DNI debe contener solo dígitos")
	private String dni;
    
	private List<Transaccion> transaccion ;
	
}