package com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta;

import com.engenhariaIII.consultorioMedico.domain.Consulta;

public class ConsultaEspecializada implements IConsulta {
	Consulta consulta = new Consulta();
	
	@Override
	public Consulta criaConsultaExame(Integer id, String Urgencia, String nomeExame, String tipoConsulta) {
		return null;
	}

	@Override
	public Consulta criaConsultaRotina(Integer id, String Urgencia, String tipoConsulta) {
		return null;
	}

	@Override
	public Consulta criaConsultaEspecializada(Integer id, String Urgencia, Boolean ehCirurgica, String Especialidade,
			String tipoConsulta) {
		
		
		
		consulta.setId(id);
		consulta.setUrgencia(Urgencia);
		consulta.setEhCirurgica(ehCirurgica);
		consulta.setEspecialidade(Especialidade);
		consulta.setTipoConsulta(tipoConsulta);
		
		System.out.println(consulta.toStringEspecialidade());
		return consulta;
		
	}
	
	
}
