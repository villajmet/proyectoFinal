
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.domain.Persona;
import com.example.demo.repositories.PersonaRepository;
import com.example.demo.repositories.TransaccionRepository;

@Service
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaRepository invRep;
	private TransaccionRepository traRep;
		
	@Override
	@Transactional
	public List<Persona> listarTodos() {
		List<Persona> personas = invRep.findAll();
		/*for(int i = 0;i< personas.size();i++) {
			personas[i].transacciones = traRep.findByIdPersona(personas[i].idPersona);	
		}
		personas.forEach(n -> n.setTransacciones(traRep.findByIdPersona(n.getIdPersona())));*/ 
		return personas;
	}

	@Override
	@Transactional
	public Persona buscarPorId(long id) {
		Optional<Persona> investigador =  invRep.findById(id);
		
		return investigador.get();
	}

	@Override
	@Transactional
	public Persona grabar(Persona investigador) {
		return invRep.save(investigador);		
	}

	@Override
	@Transactional
	public Persona actualizar(Persona investigador, Long id) {
		//investigador.setdPersona(id);
		return invRep.save(investigador);
	}

	@Override
	@Transactional
	public void eliminar(long id) {
		invRep.deleteById(id);

	}

	@Override
	@Transactional
	public Persona findByEmail(String email) {
		Optional<Persona> investigador = invRep.findByDni(email);
		return investigador.get();
	}
	
	@Override
	@Transactional
	public Persona findByDni(String email) {
		return invRep.findByEmail(email).get();		
	}

}

	

