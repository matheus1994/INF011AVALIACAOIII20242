package br.edu.ifba.inf011.model.googlecalendarservice;

public class GoogleCalendarService {
	
	public void adicionar(String mensagem) throws GoogleCalendarException {
	   if(mensagem != null) {
		   System.out.print("Mensagem adicionada ao Google Calendar!");
	   }
	   throw new GoogleCalendarException(mensagem);
	}

}
