package br.edu.ifba.inf011.strategy;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

public class EmailStrategy implements FormatoStrategy{

	@Override
	public String formatar(Evento evento) {
		
		if(this.verifica(evento)) {
			
			String mensagem =  "Descricao: " + evento.getDescricao()+ " Localizacao: " + evento.getLocalizacao() + " Inicio: " + evento.getInicio() + " Termino: " + evento.getTermino();
			this.adicionarAoGoogleCalendar(mensagem);
		}
		return null;
  
		
	}

	private boolean verifica(Evento evento) {
		if((evento.getPrioridade() >= 1 && evento.getPrioridade() <= 5) && evento.iniciaEm(LocalDate.now())) {
			return true;
		}
		return false;
		
	}
	
	private void adicionarAoGoogleCalendar(String mensagem) {
		System.out.println("Adicionando mensagem ao Google Calendar" + "\n" + mensagem);
	}

}
