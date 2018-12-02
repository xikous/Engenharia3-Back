package com.engenhariaIII.consultorioMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenhariaIII.consultorioMedico.domain.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{

}
