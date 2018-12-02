package com.engenhariaIII.consultorioMedico.DTO;

import java.io.Serializable;

import com.engenhariaIII.consultorioMedico.domain.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	//Sim ou Não
	private String convenio;
	
	public PacienteDTO() {
		
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		convenio = obj.getPossuiConvenio();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
	
	
	
}
