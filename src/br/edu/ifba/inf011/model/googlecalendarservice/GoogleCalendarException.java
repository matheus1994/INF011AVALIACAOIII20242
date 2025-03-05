package br.edu.ifba.inf011.model.googlecalendarservice;

public class GoogleCalendarException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String mensagem;
	
	public GoogleCalendarException(String mensagem) {
		this.mensagem = mensagem;
	}

}
