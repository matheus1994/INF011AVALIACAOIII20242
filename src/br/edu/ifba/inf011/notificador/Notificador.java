package br.edu.ifba.inf011.notificador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.strategy.FormatoStrategy;

public class Notificador {
	
	private FormatoStrategy strategy;
	
	public Notificador(FormatoStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void notifica(Evento e) {
		String formatado = this.strategy.formatar(e);
	}
	
}
