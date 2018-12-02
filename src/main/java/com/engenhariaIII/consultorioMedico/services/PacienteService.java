package com.engenhariaIII.consultorioMedico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.engenhariaIII.consultorioMedico.DTO.PacienteDTO;
import com.engenhariaIII.consultorioMedico.domain.Paciente;
import com.engenhariaIII.consultorioMedico.repositories.PacienteRepository;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository repo;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Paciente> findAll() {
		List<Paciente> obj = repo.findAll();
		return obj;
	}

	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Paciente fromDTO(PacienteDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getNome(), objDto.getConvenio());
	}


	public void delete(Integer id) throws DataIntegrityException {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um paciente que possui consultas");
		}
	}

	public Paciente update(Paciente obj) {
		Paciente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setPossuiConvenio(obj.getPossuiConvenio());
	}

}
