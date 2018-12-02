package com.engenhariaIII.consultorioMedico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoAvulso;
import com.engenhaIII.ConsultorioMedico.ServicosDePagamento.PagamentoConvenio;
import com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta.ConsultaFactory;
import com.engenhariaIII.ConsultorioMedico.ServicosDeConsulta.IConsulta;
import com.engenhariaIII.consultorioMedico.domain.Consulta;
import com.engenhariaIII.consultorioMedico.domain.Medico;
import com.engenhariaIII.consultorioMedico.domain.Paciente;
import com.engenhariaIII.consultorioMedico.domain.SolicitacaoConsulta;
import com.engenhariaIII.consultorioMedico.repositories.ConsultaRepository;
import com.engenhariaIII.consultorioMedico.repositories.SolicitacaoConsultaRepository;
import com.engenhariaIII.consultorioMedico.services.excepction.DataIntegrityException;

@Service
public class SolicitacaoConsultaService {
	
	SolicitacaoConsultaRepository solicitacaoRepo;
	SolicitacaoConsulta solicitacao;
	ConsultaRepository consultaRepo;
	
	MedicoService medicoService;
	PacienteService pacienteService;

	Consulta consulta = new Consulta();
	ConsultaFactory con = new ConsultaFactory();
	IConsulta icon;

	public SolicitacaoConsulta insertConsultaEspecializada(SolicitacaoConsulta obj) {

		icon = con.ObtemConsulta(obj.getConsulta().getTipoConsulta());
		consulta = icon.criaConsultaEspecializada(obj.getId(),obj.getConsulta().getUrgencia(),
												  obj.getConsulta().getEhCirurgica(),
												  obj.getMedico().getEspecialidade(), 
												  obj.getConsulta().getTipoConsulta());
		consultaRepo.save(consulta);
		
		if (consulta != null) {
			
			solicitacao.setId(null);
			solicitacao.setStatusPagamento(PagarConsulta(obj.getPaciente()));
	
			
			if(medicoService.find(obj.getMedico().getId()) != null) {
				solicitacao.setMedico(obj.getMedico());
			}
			if(pacienteService.find(obj.getPaciente().getId()) != null) {
				solicitacao.setPaciente(obj.getPaciente());
			}
		
				solicitacao.setConsulta(consulta);
				consulta.setSolicitacao(solicitacao);
			
			return solicitacaoRepo.save(solicitacao);
		}

		return null;

	}
	
	public SolicitacaoConsulta insertExame(SolicitacaoConsulta obj) {

		icon = con.ObtemConsulta(obj.getConsulta().getTipoConsulta());
		consulta = icon.criaConsultaExame(obj.getId(),obj.getConsulta().getUrgencia(),
												  obj.getConsulta().getNomeExame(),
												  obj.getConsulta().getTipoConsulta());
		
		consultaRepo.save(consulta);
		
		if (consulta != null) {
			
			solicitacao.setId(null);
			solicitacao.setStatusPagamento(PagarConsulta(obj.getPaciente()));
		
			
			if(medicoService.find(obj.getMedico().getId()) != null) {
				solicitacao.setMedico(obj.getMedico());
			}
			if(pacienteService.find(obj.getPaciente().getId()) != null) {
				solicitacao.setPaciente(obj.getPaciente());
			}
			
				solicitacao.setConsulta(consulta);
				consulta.setSolicitacao(solicitacao);
			 solicitacaoRepo.save(solicitacao);
		}

		return null;

	}
	
	public SolicitacaoConsulta insertRotina(SolicitacaoConsulta obj) {

		icon = con.ObtemConsulta(obj.getConsulta().getTipoConsulta());
		consulta = icon.criaConsultaRotina(obj.getId(),obj.getConsulta().getUrgencia(),
										   obj.getConsulta().getTipoConsulta());
		
		consultaRepo.save(consulta);
		
		if (consulta != null) {
			
			solicitacao.setId(null);
			solicitacao.setStatusPagamento(PagarConsulta(obj.getPaciente()));
		
			
			if(medicoService.find(obj.getMedico().getId()) != null) {
				solicitacao.setMedico(obj.getMedico());
			}
			if(pacienteService.find(obj.getPaciente().getId()) != null) {
				solicitacao.setPaciente(obj.getPaciente());
			}
			
				solicitacao.setConsulta(consulta);	
				consulta.setSolicitacao(solicitacao);
				
				return solicitacaoRepo.save(solicitacao);
		}

		return null;

	}
	
	
	
	public String PagarConsulta(Paciente p ) {
		String pagamento;
		
		if(p.getPossuiConvenio().toUpperCase().equals("SIM")) {
			p.setTipoPagamento(new PagamentoConvenio());
			pagamento = p.tryPagar();
		
		}else {
			p.setTipoPagamento(new PagamentoAvulso());
			pagamento = p.tryPagar();
		}
		
			
		return pagamento;
	}
	
	public SolicitacaoConsulta find(Integer id) {
		Optional<SolicitacaoConsulta > obj = solicitacaoRepo.findById(id);
		return obj.orElse(null);
	}
	
	public List<SolicitacaoConsulta> findAll() {
		List<SolicitacaoConsulta> obj = solicitacaoRepo.findAll();
		return obj;
	}
	
	public void delete(Integer id) throws DataIntegrityException {
		find(id);
		try {
			solicitacaoRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um paciente que possui consultas");
		}
	}
	
}
