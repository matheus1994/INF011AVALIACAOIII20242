package br.edu.ifba.inf011.model.googlecalendarservice;

public class GoogleCalendarService {
	
	public void adicionar(String mensagem) throws GoogleCalendarException {
	   if(mensagem != null) {
		   System.out.println("Evento adicionado ao Google Calendar: " + mensagem);
		   return;
	   }
	   throw new GoogleCalendarException(mensagem);
	}

}
