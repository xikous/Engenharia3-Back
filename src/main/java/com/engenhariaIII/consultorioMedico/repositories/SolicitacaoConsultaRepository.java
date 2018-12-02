package com.engenhariaIII.consultorioMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenhariaIII.consultorioMedico.domain.SolicitacaoConsulta;

@Repository
public interface SolicitacaoConsultaRepository extends JpaRepository<SolicitacaoConsulta, Integer>{

}
