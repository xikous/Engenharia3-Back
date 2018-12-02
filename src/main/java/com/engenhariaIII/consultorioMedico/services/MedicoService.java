package com.engenhariaIII.consultorioMedico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.engenhariaIII.consultorioMedico.DTO.MedicoDTO;
import com.engenhariaIII.consultorioMedico.domain.Medico;
import com.engenhariaIII.consultorioMedico.repositories.MedicoRepository;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository repo;
	
	public Medico find(Integer id) {
		Optional<Medico> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Medico> findAll() {
		List<Medico> obj = repo.findAll();
		return obj;
	}

	public Medico fromDTO(MedicoDTO objDto) {
		return new Medico(objDto.getId(), objDto.getNome(), objDto.getEspecialidade());
	}

	public Medico insert(Medico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) throws DataIntegrityException {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um paciente que possui consultas");
		}
	}

	public Medico update(Medico obj) {
		Medico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Medico newObj, Medico obj) {
		newObj.setEspecialidade(obj.getEspecialidade());
	}

}
