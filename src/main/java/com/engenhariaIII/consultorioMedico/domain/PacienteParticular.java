package com.engenhariaIII.consultorioMedico.domain;

import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoAvulso;

public class PacienteParticular extends Paciente{
	private static final long serialVersionUID = 1L;
	
	public PacienteParticular() {
		tipoPagamento =  new PagamentoAvulso();
	}
}
