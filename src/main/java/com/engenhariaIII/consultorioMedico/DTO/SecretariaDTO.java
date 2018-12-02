package com.engenhariaIII.consultorioMedico.DTO;

import com.engenhariaIII.consultorioMedico.domain.Secretaria;

public class SecretariaDTO {
	private String nome;
	private Integer id;
	
	
	public SecretariaDTO(Secretaria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
	public SecretariaDTO(String nome, Integer id) {
		super();
		this.nome = nome;
		this.id = id;
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
	
	
	
}
