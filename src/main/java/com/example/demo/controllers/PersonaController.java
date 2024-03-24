
package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.ApiResponse;

import jakarta.validation.Valid;

import com.example.demo.exception.IllegalOperationException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.domain.Persona;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.services.PersonaService;

@RestController
@RequestMapping(value = "/api/v1/personas")//, headers ="X-VERSION=1.0.0")
public class PersonaController {
	@Autowired
	private PersonaService perService;
	
	@Autowired
    private ModelMapper modelMapper;
		
	
	 @GetMapping
    public ResponseEntity<?> ListarPersonas(){
    	List<Persona> investigadores = perService.listarTodos();
    	if(investigadores==null || investigadores.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
    	else 
    	{     
    		List<PersonaDTO> investigadorDTOs = investigadores.stream()
    				.map(departamento -> modelMapper.map(departamento, PersonaDTO.class))
    				.collect(Collectors.toList());
    		ApiResponse<List<PersonaDTO>> response = new ApiResponse<>(true, "Lista de investigadores obtenida con éxito", investigadorDTOs);
    		return ResponseEntity.ok(response);
    	}

    }
			
	
	 @GetMapping("/{id}")
	    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {      
		 Persona investigador = perService.buscarPorId(id);
		 PersonaDTO investigadorDTO = modelMapper.map(investigador, PersonaDTO.class);
	    	ApiResponse<PersonaDTO> response = new ApiResponse<>(true, "Datos del persona obtenidos con éxito", investigadorDTO);
	    	return ResponseEntity.ok(response);
	    }
	 
	
	 @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody PersonaDTO personaDTO) throws IllegalOperationException{	   	    	
	 Persona persona = modelMapper.map(personaDTO, Persona.class);
	 perService.grabar(persona);
    	PersonaDTO savedInvestigadorDTO = modelMapper.map(persona, PersonaDTO.class);
    	ApiResponse<PersonaDTO> response = new ApiResponse<>(true, "Datos de persona grabados con éxito", savedInvestigadorDTO);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	 
		
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException {
		perService.eliminar(id);
    	ApiResponse<?> response = new ApiResponse<>(true, "Investigador eliminado con éxito", null);
    	return ResponseEntity.status(HttpStatus.OK).body(response);//NO_CONTENT
    }  
}

