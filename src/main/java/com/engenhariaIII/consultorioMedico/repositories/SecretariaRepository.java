package com.engenhariaIII.consultorioMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenhariaIII.consultorioMedico.domain.Secretaria;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria,Integer> {

}
