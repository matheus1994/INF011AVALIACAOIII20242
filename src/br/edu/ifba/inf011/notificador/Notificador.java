package br.edu.ifba.inf011.notificador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;
import br.edu.ifba.inf011.strategy.FormatoException;
import br.edu.ifba.inf011.strategy.FormatoStrategy;

public class Notificador {
	
	private FormatoStrategy strategy;
	private GoogleCalendarService googleCalendar;
	
	public Notificador(FormatoStrategy strategy, GoogleCalendarService googleCalendar) {
		this.strategy = strategy;
		this.googleCalendar = googleCalendar;
	}
	
	public void notificar(Evento e) throws FormatoException, GoogleCalendarException {
		String formatado = this.strategy.formatar(e);
		this.googleCalendar.adicionar(formatado);
	}
	
}
