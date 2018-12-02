package com.engenhariaIII.consultorioMedico.DTO;

import java.io.Serializable;

import com.engenhariaIII.consultorioMedico.domain.Medico;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String especialidade;
	
	public MedicoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MedicoDTO(Medico obj) {
		id = obj.getId();
		nome = obj.getNome();
		especialidade = obj.getEspecialidade();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
