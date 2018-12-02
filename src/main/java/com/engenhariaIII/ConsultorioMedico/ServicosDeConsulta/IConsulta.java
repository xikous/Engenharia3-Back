package com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta;

import com.engenhariaIII.consultorioMedico.domain.Consulta;

public interface IConsulta {

	public Consulta criaConsultaExame(Integer id, String Urgencia, String nomeExame, String tipoConsulta);

	public Consulta criaConsultaRotina(Integer id, String Urgencia, String tipoConsulta);

	public Consulta criaConsultaEspecializada(Integer id, String Urgencia, Boolean ehCirurgica, String Especialidade,
			String tipoConsulta);

}
