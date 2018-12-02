package com.engenhariaIII.consultorioMedico.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.Pagamento;
import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoStrategy;

@Entity
public class Paciente extends Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	//sim ou não
	private String possuiConvenio;
	
	@OneToMany(mappedBy="paciente", cascade=CascadeType.ALL)
	private List<SolicitacaoConsulta> solicitacoesConsultas; 
	
	
	@OneToMany(mappedBy="paciente", cascade=CascadeType.ALL)
	private List<Diagnostico> diagnosticos;
	
	@Transient
	PagamentoStrategy tipoPagamento;


	public Paciente() {
		
	}
	
	public Paciente(Integer id, String nome, String convenio) {
		super();
		this.id = id;
		this.nome = nome;
		this.possuiConvenio = convenio;
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
	public String getPossuiConvenio() {
		return possuiConvenio;
	}
	public void setPossuiConvenio(String possuiConvenio) {
		this.possuiConvenio = possuiConvenio;
	}
	
	
	
	public List<SolicitacaoConsulta> getSolicitacoesConsultas() {
		return solicitacoesConsultas;
	}

	public void setSolicitacoesConsultas(List<SolicitacaoConsulta> solicitacoesConsultas) {
		this.solicitacoesConsultas = solicitacoesConsultas;
	}

	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public PagamentoStrategy getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(PagamentoStrategy tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", possuiConvenio=" + possuiConvenio + "]";
	}
	

	
	
}
