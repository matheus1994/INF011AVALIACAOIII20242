package br.edu.ifba.inf011.strategy;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

public class WhatsappStrategy implements FormatoStrategy{

	@Override
	public String formatar(Evento evento) throws FormatoException {
		
		if(this.verifica(evento)) {
			
			String mensagem =  "Descricao: " + evento.getDescricao()+ " Localizacao: " + evento.getLocalizacao() + " Inicio: " + evento.getInicio() + " Termino: " + evento.getTermino();
			return mensagem;
			
		}
		throw new FormatoException(evento);
		
	}

	private boolean verifica(Evento evento) {
		if((evento.getPrioridade() >= 6 && evento.getPrioridade() <= 10) && evento.iniciaEm(LocalDate.now())) {
			return true;
		}
		return false;
		
	}
	
}