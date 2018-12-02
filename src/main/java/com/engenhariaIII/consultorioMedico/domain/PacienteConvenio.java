package com.engenhariaIII.consultorioMedico.domain;

import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoConvenio;

public class PacienteConvenio extends Paciente{
	private static final long serialVersionUID = 1L;
	
	public PacienteConvenio() {
		tipoPagamento =  new PagamentoConvenio();
	}
	
}
