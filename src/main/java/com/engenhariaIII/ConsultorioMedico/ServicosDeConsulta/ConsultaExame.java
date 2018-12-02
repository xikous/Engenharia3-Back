package com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta;

import com.engenhariaIII.consultorioMedico.domain.Consulta;

public class ConsultaExame extends Consulta implements IConsulta {
	
	
	private Consulta obj = new Consulta();
	

	@Override
	public Consulta criaConsultaExame(Integer id, String urgencia, String nomeExame,
			 String tipoConsulta) {
		obj.setId(id);
		obj.setUrgencia(urgencia);
		obj.setNomeExame(nomeExame);
		obj.setTipoConsulta(tipoConsulta);
		
		System.out.println(obj.toStringExame());
		return obj;
	}


	@Override
	public Consulta criaConsultaRotina(Integer id, String Urgencia, String tipoConsulta) {
		return null;
		
	}


	@Override
	public Consulta criaConsultaEspecializada(Integer id, String Urgencia, Boolean ehCirurgica, String Especialidade,
			String tipoConsulta) {
		return null;
		
	}

	
}
