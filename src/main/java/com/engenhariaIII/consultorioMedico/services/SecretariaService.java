package com.engenhariaIII.consultorioMedico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.engenhariaIII.consultorioMedico.DTO.SecretariaDTO;
import com.engenhariaIII.consultorioMedico.domain.Secretaria;
import com.engenhariaIII.consultorioMedico.repositories.SecretariaRepository;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@Service
public class SecretariaService {
	@Autowired
	SecretariaRepository repo;

	public Secretaria find(Integer id) {
		Optional<Secretaria> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Secretaria> findAll() {
		List<Secretaria> obj = repo.findAll();
		return obj;
	}

	public Secretaria fromDTO(SecretariaDTO objDto) {
		return new Secretaria(objDto.getId(), objDto.getNome());
	}

	public Secretaria insert(Secretaria obj) {
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

	public Secretaria update(Secretaria obj) {
		Secretaria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Secretaria newObj, Secretaria obj) {
		newObj.setNome(obj.getNome());
	}
}
