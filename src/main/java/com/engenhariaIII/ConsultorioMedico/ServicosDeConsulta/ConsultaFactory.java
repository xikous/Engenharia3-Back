package com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta;

public class ConsultaFactory {
	IConsulta icon;
	
	public IConsulta ObtemConsulta(String consulta) 
	{
		if(consulta.toUpperCase().equals("EXAME")) {
			return new ConsultaExame();
		}else if(consulta.toUpperCase().equals("ROTINA")) {
			return new ConsultaRotina();
		}else if(consulta.toUpperCase().equals("ESPECIALISTA")) {
			return new ConsultaEspecializada();
		}
		
		return null;
	}
}
