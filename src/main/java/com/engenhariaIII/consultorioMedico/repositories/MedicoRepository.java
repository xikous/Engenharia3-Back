package com.engenhariaIII.consultorioMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenhariaIII.consultorioMedico.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
