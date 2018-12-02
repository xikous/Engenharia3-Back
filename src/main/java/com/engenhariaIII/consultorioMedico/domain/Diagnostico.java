package com.engenhariaIII.consultorioMedico.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Diagnostico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_medicoResponsavel")
	private Medico medicoResponsavel;
	
	@ManyToOne
	@JoinColumn(name="cod_Paciente")
	private Paciente paciente;
	
	public Diagnostico() {
		
	}
	
	public Diagnostico(Integer id, Date data, String descricao, Medico medicoResponsavel) {
		super();
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.medicoResponsavel = medicoResponsavel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Medico getMedicoResponsavel() {
		return medicoResponsavel;
	}

	public void setMedicoResponsavel(Medico medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnostico other = (Diagnostico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
