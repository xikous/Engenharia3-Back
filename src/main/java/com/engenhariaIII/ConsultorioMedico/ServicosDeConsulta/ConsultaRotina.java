package com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta;

import com.engenhariaIII.consultorioMedico.domain.Consulta;

public class ConsultaRotina implements IConsulta{
	Consulta consulta = new Consulta();

	@Override
	public Consulta criaConsultaExame(Integer id, String Urgencia, String nomeExame, String tipoConsulta) {
		return null;
		
	}

	@Override
	public Consulta criaConsultaRotina(Integer id, String Urgencia, String tipoConsulta) {
		consulta.setId(id);
		consulta.setUrgencia(Urgencia);
		consulta.setTipoConsulta(tipoConsulta);
		
		System.out.println("Consulta: " + consulta.toStringRotina());
		
		return consulta;
		
	}

	@Override
	public Consulta criaConsultaEspecializada(Integer id, String Urgencia, Boolean ehCirurgica, String Especialidade,
			String tipoConsulta) {
		return null;
		
	}

	
	
}
