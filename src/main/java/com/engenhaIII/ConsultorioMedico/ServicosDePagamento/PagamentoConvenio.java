package com.engenhaIII.ConsultorioMedico.ServicosDePagamento;

public class PagamentoConvenio implements PagamentoStrategy {

	@Override
	public String pagar() {
		return "Pagamento via Convenio efetivado com sucesso!";		
	}
	
}
