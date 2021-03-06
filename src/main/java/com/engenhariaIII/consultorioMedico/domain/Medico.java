package com.engenhariaIII.consultorioMedico.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String Especialidade;
	
	@OneToMany(mappedBy="medico",cascade=CascadeType.ALL)
	private List <SolicitacaoConsulta> consultasMarcadas;
	
	@OneToMany(mappedBy="medicoResponsavel")
	private List <Diagnostico> diagnosticos;
	
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Medico(Integer id, String nome, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		Especialidade = especialidade;
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
		return Especialidade;
	}
	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", Especialidade=" + Especialidade + "]";
	} 
	
	
	
}
