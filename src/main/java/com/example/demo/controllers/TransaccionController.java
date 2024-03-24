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

import com.example.demo.domain.Transaccion;
import com.example.demo.dto.TrasaccionDTO;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.IllegalOperationException;
import com.example.demo.services.TransaccionService;
import com.example.demo.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionController {

	
	@Autowired
	private TransaccionService traService;
	
	@Autowired
    private ModelMapper modelMapper;
	
		
	 @GetMapping
	    public ResponseEntity<?> ListarTodos(){
	    	List<Transaccion> investigadores = traService.listarTodos();
	    	if(investigadores==null || investigadores.isEmpty()) {
	    		return ResponseEntity.noContent().build();
	    	}
	    	else 
	    	{     
	    		List<TrasaccionDTO> investigadorDTOs = investigadores.stream()
	    				.map(departamento -> modelMapper.map(departamento, TrasaccionDTO.class))
	    				.collect(Collectors.toList());
	    		ApiResponse<List<TrasaccionDTO>> response = new ApiResponse<>(true, "Lista de transacciones obtenida con éxito", investigadorDTOs);
	    		return ResponseEntity.ok(response);
	    	}

	    }

	@PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody TrasaccionDTO personaDTO) throws IllegalOperationException{	   	    	
		Transaccion persona = modelMapper.map(personaDTO, Transaccion.class);
	 traService.grabar(persona);
	 TrasaccionDTO savedInvestigadorDTO = modelMapper.map(persona, TrasaccionDTO.class);
    	ApiResponse<TrasaccionDTO> response = new ApiResponse<>(true, "Datos de transacción grabados con éxito", savedInvestigadorDTO);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
		
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException {
		traService.eliminar(id);
    	ApiResponse<?> response = new ApiResponse<>(true, "transacció eliminado con éxito", null);
    	return ResponseEntity.status(HttpStatus.OK).body(response);//NO_CONTENT
    }  
	
}
