package com.engenhariaIII.consultorioMedico.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.Pagamento;
import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoAvulso;
import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoConvenio;
import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoStrategy;

@Entity
public class SolicitacaoConsulta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String statusPagamento;

	@ManyToOne
	@JoinColumn(name = "cod_Paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "cod_Medico")
	private Medico medico;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_consulta")
	private Consulta consulta;

	public SolicitacaoConsulta() {
		// TODO Auto-generated constructor stub
	}

	


	public SolicitacaoConsulta(Integer id, String tipoConsulta, String statusPagamento, Paciente paciente,
			Medico medico, Consulta consulta) {
		super();
		this.id = id;
		this.statusPagamento = statusPagamento;
		this.paciente = paciente;
		this.medico = medico;
		this.consulta = consulta;
	}

	public SolicitacaoConsulta(SolicitacaoConsulta obj) {
		super();
		this.id = obj.getId();
		this.statusPagamento = obj.getStatusPagamento();
		this.paciente = obj.getPaciente();
		this.medico = obj.getMedico();
		this.consulta = obj.getConsulta();
	}

	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public void marcarConsulta() {
		Pagamento pagamento = new Pagamento();
		if (paciente.getPossuiConvenio().toUpperCase().equals("SIM")) {
			
			pagamento.setTipoPagamento(new PagamentoConvenio());
			statusPagamento = pagamento.tryPagar();
			System.out.println(pagamento.tryPagar());
			
		} else {
			
			pagamento.setTipoPagamento(new PagamentoAvulso());
			statusPagamento = pagamento.tryPagar();
			System.out.println(pagamento.tryPagar());
		}

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
		SolicitacaoConsulta other = (SolicitacaoConsulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}
