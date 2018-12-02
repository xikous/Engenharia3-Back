package com.engenhariaIII.consultorioMedico.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String urgencia;
	private Boolean ehCirurgica;
	private String Especialidade;
	private String nomeExame;
	private String tipoConsulta;
	
	
	@OneToOne(mappedBy="consulta")
	private SolicitacaoConsulta solicitacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}
	public Boolean getEhCirurgica() {
		return ehCirurgica;
	}
	public void setEhCirurgica(Boolean ehCirurgica) {
		this.ehCirurgica = ehCirurgica;
	}
	public String getEspecialidade() {
		return Especialidade;
	}
	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}
	public String getNomeExame() {
		return nomeExame;
	}
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	
	
	public SolicitacaoConsulta getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(SolicitacaoConsulta solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	public String toStringRotina() {
		return "Consulta [id=" + id + ", Tipo de Consulta= " + tipoConsulta + ", Urgência=" + urgencia + "]";
	}
	
	public String toStringExame() {
		return "Consulta [id=" + id + ", Tipo de Consulta= " + tipoConsulta + ", Urgencia=" + urgencia + ", nomeExame=" + nomeExame + "]";
	}
	
	public String toStringEspecialidade() {
		return "Consulta [id=" + id + ", Tipo de Consulta= " + tipoConsulta + ", Urgencia=" + urgencia + ", ehCirurgica=" + ehCirurgica + ", Especialidade="
				+ Especialidade + "]";
	}


	
	
	
	

	
	
}
