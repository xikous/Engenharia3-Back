package com.engenhaIII.ConsultorioMedico.ServicosDePagamento;

public class PagamentoAvulso implements PagamentoStrategy{

	@Override
	public String pagar() {
		return "Pagamento Particular realizado com sucesso!";		
	}

}
