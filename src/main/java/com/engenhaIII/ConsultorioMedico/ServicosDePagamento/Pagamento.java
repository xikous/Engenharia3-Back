package com.engenhaIII.ConsultorioMedico.ServicosDePagamento;

public class Pagamento {
	private PagamentoStrategy pgto;
	
	public String tryPagar() {
		return pgto.pagar();
	}
	
	public void setTipoPagamento(PagamentoStrategy pgto) {
		this.pgto = pgto;
	}
}
