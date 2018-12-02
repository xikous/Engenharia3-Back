package com.engenhariaIII.consultorioMedico.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.engenhariaIII.consultorioMedico.DTO.SecretariaDTO;

import com.engenhariaIII.consultorioMedico.domain.Secretaria;
import com.engenhariaIII.consultorioMedico.services.SecretariaService;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@RestController
@RequestMapping(value="/secretarias")
public class SecretariaResource {
		@Autowired
		SecretariaService service;
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<SecretariaDTO>> findAll() {
			List<Secretaria> list = service.findAll();
			List<SecretariaDTO> listDto = list.stream().map(obj -> new SecretariaDTO(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(listDto);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id) {
			Secretaria obj = service.find(id); 
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody SecretariaDTO objDto) {
			Secretaria obj = service.fromDTO(objDto);
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
}
