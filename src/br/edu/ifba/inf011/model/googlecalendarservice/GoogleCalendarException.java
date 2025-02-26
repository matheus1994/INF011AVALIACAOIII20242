package br.edu.ifba.inf011.model.googlecalendarservice;

public class GoogleCalendarException extends Exception {
	
	private String mensagem;
	
	public GoogleCalendarException(String mensagem) {
		this.mensagem = mensagem;
	}

}
