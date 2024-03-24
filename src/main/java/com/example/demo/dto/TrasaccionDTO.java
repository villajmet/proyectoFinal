package com.example.demo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class TrasaccionDTO {
	private Long idTransaccion;	
	
	@NotBlank(message = "El titulo no puede estar en blanco")
	@Size(min = 0, message = "El precio debe ser mayor a 0")
    private float precio;
	@PastOrPresent
	@NotNull(message = "La fecha de transacción no puede ser vacía o no sigue el patron yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaTransaccion;
	
	/*private List<ProyectoInvestigacion> proyectos ;*/
	
}