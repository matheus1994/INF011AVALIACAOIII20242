package br.edu.ifba.inf011.strategy;

import br.edu.ifba.inf011.model.evento.Evento;

public class FormatoException extends Exception{
	
	private Evento evento;

	public FormatoException(Evento evento) {
		this.evento = evento;
	}
	
}
