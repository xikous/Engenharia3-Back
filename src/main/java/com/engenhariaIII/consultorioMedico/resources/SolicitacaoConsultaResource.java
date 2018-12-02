package com.engenhariaIII.consultorioMedico.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.engenhariaIII.consultorioMedico.DTO.PacienteDTO;
import com.engenhariaIII.consultorioMedico.domain.Paciente;
import com.engenhariaIII.consultorioMedico.domain.SolicitacaoConsulta;
import com.engenhariaIII.consultorioMedico.services.SolicitacaoConsultaService;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@RestController
@RequestMapping(value="/pacientes")
public class SolicitacaoConsultaResource {
	SolicitacaoConsultaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SolicitacaoConsulta>> findAll() {
		List<SolicitacaoConsulta> list = service.findAll();  
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		SolicitacaoConsulta obj = service.find(id); 
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PacienteDTO objDto) {
		Paciente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws DataIntegrityException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PacienteDTO objDto, @PathVariable Integer id) {
		Paciente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
